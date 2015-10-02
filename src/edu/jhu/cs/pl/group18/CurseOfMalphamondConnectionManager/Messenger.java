/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import edu.jhu.cs.pl.group18.CurseOfMalphamond.Exception.PlayerCantAccessServerException;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.AddPlayerCommand;
import edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command;


/**
 * This class provides a messenger implementation. The model proxy on the client
 * side will use the object of this class to send message to the model Impl on
 * the server side.
 * @author Yunlong
 * @version 1.2
 * @since 1.0
 */
public class Messenger {
	
	private Client client;
	private Connection connection;
	
	private Thread connectionThread;
	private Thread sendThread;
	private Thread closeConnection = new Thread();
	
	private boolean isConnected = false;
	private boolean isReceived  = false;
	private boolean registerSuccess = false;
	
	private Command response;
	
	private List<MessengerListener> listeners;
	
	/**
	 * Constructor
	 */
	public Messenger() {
		
		listeners = new ArrayList<>();
		client = new Client();
		client.start();
		
		Network.register( client );
		
		client.addListener( new Listener() {

			/* (non-Javadoc)
			 * @see com.esotericsoftware.kryonet.Listener#connected(com.esotericsoftware.kryonet.Connection)
			 */
			@Override
			public void connected(Connection arg0) {
				isConnected = true;
				connection = arg0;
			}

			/* (non-Javadoc)
			 * @see com.esotericsoftware.kryonet.Listener#disconnected(com.esotericsoftware.kryonet.Connection)
			 */
			@Override
			public void disconnected(Connection arg0) {
				isConnected = false;
				isReceived = false;
				connection = null;
			}

			/* (non-Javadoc)
			 * @see com.esotericsoftware.kryonet.Listener#idle(com.esotericsoftware.kryonet.Connection)
			 */
			@Override
			public void idle(Connection connection) {
			}

			/* (non-Javadoc)
			 * @see com.esotericsoftware.kryonet.Listener#received(com.esotericsoftware.kryonet.Connection, java.lang.Object)
			 */
			@Override
			public void received(Connection connection, Object object) {
				
				if (object instanceof Command){
					
					isReceived = true;
					response = (Command) object;
					
					for ( MessengerListener listener : listeners ) {
						listener.messageReceived( new MessageReceivedEvent( client, response ) );
					}
					
					registerSuccess = true;
					
				}
				
			}
		});
		
	}
	
	/**
	 * Add a listener to this messenger
	 * @param listener the listener to add.
	 */
	public void addListener( MessengerListener listener ) {
		this.listeners.add(listener);
	}
	
	/**
	 * Remove a specific listener to this messenger
	 * @param listener the listener to remove.
	 */
	public void removeListener( MessengerListener listener ) {
		this.listeners.remove(listener);
	}
	
	/**
	 * Call this method to connect the contract server.
	 */
	public void connectServer() throws PlayerCantAccessServerException {
		
		connectionThread = new Thread() {
			public void run() {
				try {
						client.connect(1000, Network.getServerHost(), Network.getContractPortNumber());
						synchronized( connectionThread ){
							connectionThread.notify();
						}
				} catch (IOException e) {
				}
				synchronized( closeConnection ) {
					try {
						closeConnection.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		connectionThread.start();
		
	}
	
	/**
	 * Send a command from model proxy to model impl.
	 * @param command
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void sendCommand( Command command ) throws IOException, InterruptedException {
		
		final Command commandForSent = command;
		this.isReceived = false;
		
		sendThread = new Thread("SendMessage"){
			
			public void run() {

				if ( !isConnected ) {
					synchronized( connectionThread ){
						try {
							connectionThread.wait();
						} catch (InterruptedException e) {
							return;
						}
						
						connection.sendTCP( commandForSent );
					}
				} else {
					connection.sendTCP( commandForSent );
				}
				
				synchronized( this ) {
					this.notify();
				}
				
			}
		};
		sendThread.start();
		
	}
	/**
	 * This function works very harshly to closed out the connection.
	 * The stopConnection should only be called when the game is over,
	 * or the player is off the game.
	 */
	public void stopConnection() {
		
		closeConnection = new Thread("closeConnection"){
			
			public void run() {
				
				if ( !isConnected ) {
					synchronized( connectionThread ){
						try {
							connectionThread.wait();
						} catch (InterruptedException e) {
							return;
						}
						
					}
				} else {
					synchronized( sendThread ) {
						try {
							sendThread.wait();
						} catch (InterruptedException e) {
							return;
						}
					}
				}
				synchronized( this ) {
					notify();
				}
				
				connectionThread.interrupt();
				
			}
		};
		closeConnection.start();
		
	}
	
	/**
	 * @return a boolean value saying that whether the messenger is connected.
	 */
	public boolean isConnected() {
		return isConnected;
	}

	/**
	 * Call this function to know whether the model
	 * @return the isReceived
	 */
	public boolean isReceived() {
		return isReceived;
	}

	/**
	 * The one-time set boolean value to see whether the registeration is good.
	 * @return the registerSuccess
	 */
	public boolean isRegisterSuccess() {
		return registerSuccess;
	}

	/**
	 * Call this getter to get the response from the server.
	 * @return the response
	 */
	public Command getResponse() {
		return response;
	}
	
}
