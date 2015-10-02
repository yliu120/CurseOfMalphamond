/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.PlayerFullException;
import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.ServerPortUnbindException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.AddPlayerCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.CanChallengeBossCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.EndTurnCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.RegisterConnectionCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.RemovePlayerCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.ThrowExceptionCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateCharacterCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateCurrentActivePlayerCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateCurrentTileCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateDiceCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateFightCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateHandCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdatePlayersCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character;
import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand;

/**
 * This class provides an implementation of the connection manager. The model
 * implementation on the server side should receive and manage messages sent by
 * each client that is playing the game.
 * 
 * @author Yunlong
 * @version 1.5
 * @since 1.1
 */
public class ConnectionManager {

	private Server server;
	private final Set<Connection> clients = new HashSet<>();
	private final Map<Connection, Player> registeredPlayer = new HashMap<>();
	private CurseOfMalphamondModelImpl modelImpl = new CurseOfMalphamondModelImpl();
	private Connection activeConnection = null;

	/**
	 * Constructor
	 * @throws ServerPortUnbindException
	 */
	public ConnectionManager() throws ServerPortUnbindException {

		Server server = new Server();
		server.start();

		try {
			server.bind(Network.getContractPortNumber());
		} catch (IOException e) {
			throw new ServerPortUnbindException();
		}

		Network.register(server);

		server.addListener(new Listener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * com.esotericsoftware.kryonet.Listener#connected(com.esotericsoftware
			 * .kryonet.Connection)
			 */
			@Override
			public void connected(Connection arg0) {

				if (!clients.contains(arg0)) {

					try {
						checkConnectionSize();
					} catch (PlayerFullException e) {
						arg0.sendTCP(new ThrowExceptionCommand(e.getMessage()));
						return;
					}

					clients.add(arg0);

					checkStartGame();
				}

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see com.esotericsoftware.kryonet.Listener#disconnected(com.
			 * esotericsoftware.kryonet.Connection)
			 */
			@Override
			public void disconnected(Connection arg0) {

				if (clients.contains(arg0)) {
					
					clients.remove(arg0);
					modelImpl.removePlayer(registeredPlayer.remove(arg0));
					
					if (checkAllOutOfGame()) {
						modelImpl = new CurseOfMalphamondModelImpl();
						
					}	
				}
			}
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * com.esotericsoftware.kryonet.Listener#idle(com.esotericsoftware
			 * .kryonet.Connection)
			 */
			@Override
			public void idle(Connection connection) {
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * com.esotericsoftware.kryonet.Listener#received(com.esotericsoftware
			 * .kryonet.Connection, java.lang.Object)
			 */
			@Override
			public void received(Connection connection, Object object) {

				if (activeConnection == null) {

					if (object instanceof RegisterConnectionCommand) {

						if (registeredPlayer.size() == 4) {
							ThrowExceptionCommand gameFull = new ThrowExceptionCommand(
									"The game is full!");
							connection.sendTCP(gameFull);
							return;
						}

						registeredPlayer.put(connection,
								((RegisterConnectionCommand) object)
										.getPlayer());

						try {
							((Command) object).execute(modelImpl);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						UpdatePlayersCommand updatePlayers = new UpdatePlayersCommand(
								modelImpl.getPlayers());
						connection.sendTCP(updatePlayers);

					} else {

						if (object instanceof Command) {
							String exception = "Sorry, the game will not start until we have four person!";
							connection.sendTCP(new ThrowExceptionCommand(
									exception));
						}

					}

				} else {

					if (connection.equals(activeConnection)) {

						if (object instanceof Command) {

							Command command = (Command) object;
							try {
								command.execute(modelImpl);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							if (command instanceof EndTurnCommand) {
								
							}

							// updateClients();
						}
					} else {
						connection.sendTCP(new ThrowExceptionCommand(
								"This is not your turn!"));
					}

				}

			}

		});

		this.modelImpl.addListener(new ModelListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelImplListener
			 * #playerInfoChanged()
			 */
			@Override
			public void playerInfoChanged() {

				for (Connection client : clients) {
					Command updatePlayer = new UpdatePlayersCommand(modelImpl
							.getPlayers());
					client.sendTCP(updatePlayer);
				}

			}

			@Override
			public void gameExceptionThrowed() {
				// TODO Auto-generated method stub

			}

			@Override
			public void diceRolled() {
				for (Connection client : clients) {
					Command updateDice = new UpdateDiceCommand(modelImpl
							.getDiceNumber());
					client.sendTCP(updateDice);
				}
			}

			@Override
			public void boardInfoChanged() {
				// TODO Auto-generated method stub

			}

			@Override
			public void currentActivePlayerChanged() {

				// Here the connection manager setups activeConnection
				Player cp = modelImpl.getCurrentActivePlayer();
				for (Connection connection : registeredPlayer.keySet()) {
					connection
							.sendTCP(new UpdateCurrentActivePlayerCommand(cp));
					if (registeredPlayer.get(connection).equals(cp)) {
						activeConnection = connection;
					}
				}

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener#
			 * playerAdded()
			 */
			@Override
			public void playerAdded(Player player) {
				
				for (Connection client : clients) {
					Command addPlayer = new AddPlayerCommand(player);
					client.sendTCP(addPlayer);
				}

			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondModel.ModelListener#
			 * playerRemoved()
			 */
			@Override
			public void playerRemoved(Player player) {

				for (Connection client : clients) {
					Command addPlayer = new RemovePlayerCommand(player);
					client.sendTCP(addPlayer);
				}

			}

			@Override
			public void currentTileChanged() {
				for (Connection client : clients) {
					Command updateCurrentTile = new UpdateCurrentTileCommand(
							modelImpl.getTileAtPosition(modelImpl.getCurrentActivePlayer().getCharacter().getCurrentPosition()));
					client.sendTCP(updateCurrentTile);
				}
			}

			@Override
			public void monsterAttacked(String s) {
				for (Connection client : clients) {
					Command updateFightCommand = new UpdateFightCommand(s);
					client.sendTCP(updateFightCommand);
					Command updateCharacter = new UpdateCharacterCommand(
							modelImpl.getCurrentActivePlayer().getCharacter(), modelImpl.getCurrentActivePlayer().getUsername(), null);
					client.sendTCP(updateCharacter);
				}
			}

			@Override
			public void handChanged(Hand hand, String username) {

				for (Connection client : clients) {

					if (registeredPlayer.get(client).getUsername()
							.equals(username)) {
						Command updateHandCommand = new UpdateHandCommand(hand,
								username);
						client.sendTCP(updateHandCommand);
					}
					
				}
			}

			@Override
			public void canChallengeBoss(String result) {
				for (Connection client : clients) {
					Command canChallengeBossCommand = new CanChallengeBossCommand(
							result);
					client.sendTCP(canChallengeBossCommand);
				}
			}

			@Override
			public void characterChanged(Character character, String username, String result) {
				for (Connection client : clients) {
					Command updateCharacterCommand = new UpdateCharacterCommand(character, username, result);
					client.sendTCP(updateCharacterCommand);
				}
			}
		});

	}

	private void checkStartGame() {

		if (this.modelImpl.getPlayers().size() == 4) {
			this.modelImpl.initializeGame();
		}

	}

	/**
	 * Stops the service of the manager.
	 */
	public void stopServerService() {

		this.clients.clear();
		server.close();

	}

	/*
	private void updateClients() {

		System.out.println("Current Players in the Game:");

		for (Player player : this.modelImpl.getPlayers()) {
			System.out.println(player.getUsername());
		}

	}*/

	private void checkConnectionSize() throws PlayerFullException {
		if (this.clients.size() == 4) {
			throw new PlayerFullException();
		}
	}

	private boolean checkAllOutOfGame() {
		if (this.clients.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get the model impl.
	 * @return The modelImpl
	 */
	public CurseOfMalphamondModelImpl getModelImpl() {
		return modelImpl;
	}

}
