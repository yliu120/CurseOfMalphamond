/**
 * 
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

/**
 * This is the network for communication between the server and the clients.
 * @author Yunlong
 * @version 1.2
 */
public class Network {
	
	private static final int contractPortNumber = 53233;
	private static String serverHost = "127.0.0.1";
	private static String serverIP = "";
	
	/**
	 * Default constructor
	 */
	public Network() {
	}
	
	/**
	 * User may call this constructor to setup the server location
	 * @param serverHost
	 */
	public Network( String serverHost ) {
		
		this.serverHost = serverHost;
		
	}
	
	/**
	 * Register in the kryonet.
	 * @param endPoint The end point
	 */
	static public void register (EndPoint endPoint) {
		
		Kryo kryo = endPoint.getKryo();
		
		/*
		 * Registering all the command class here!
		 */
		kryo.register(java.net.InetSocketAddress.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.CommandTest.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.CommandTest2.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.RegisterConnectionCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdatePlayersCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.AddPlayerCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.RemovePlayerCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.RollDiceCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateDiceCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.MoveNumTilesCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateCharacterCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateHandCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateCurrentTileCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.FightCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateFightCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.EndTurnCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.CanChallengeBossCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.ThrowExceptionCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.UpdateCurrentActivePlayerCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.ActionTileActCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.ResourceTileActCommand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.PlayCardCommand.class);


		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Position.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Player.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.CardContainer.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Hand.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.Deck.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CardContainer.UsedCards.class);
		
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Actor.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Character.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Boss.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monster.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterDragon.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterPhoenix.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterBeast.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterDevil.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Monsters.MonsterOctopus.class);

		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterBerserker.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterDemon.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterMage.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterPhilosopher.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterPriest.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterRoyalGuard.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor.Characters.CharacterScout.class);
		kryo.register(java.util.ArrayList.class);
		kryo.register(java.util.List.class);
		kryo.register(String.class);
		
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Dice.class);
		
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.MonsterTile.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.ActionTile.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.Tile.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.TileType.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.ResourceTile.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.EmptyTile.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.MovementTile.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.OptionTile.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.HealingFountainTile.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Tile.DrawingTile.class);

		//kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.AfterBattleCard.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.AfterRollDiceCard.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BeforeBattleCard.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BeforeRollDiceCard.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.DuringTurnCard.class);
		//kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.EnemyTurnCard.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.Card.class);
		
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.BasicCard.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CardType.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.CharacterCard.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.ExtraCard.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.MonsterCard.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CardType.ResourceCard.class);
		
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Courage.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Dart.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Fortitude.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.GrandMarch.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.GrandRetreat.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.GreatCourage.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.GreatFortitude.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.HealthPotion.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Longevity.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.March.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Panacea.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Reroll.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Retreat.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.BasicCards.Slash.class);
		
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.Duplicate.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.Meditate.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.Nightmare.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.Prayer.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.SeismicSlam.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.ShieldToss.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.CharacterCards.Sprint.class);
		
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ExtraCards.DuplicatedCard.class);
		
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.MonsterCards.Marathon.class);
		
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards.Deceive.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards.Hustle.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards.LightningBolt.class);
		kryo.register(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Card.ResourceCards.PhysicalTraining.class);
		
	}
	
	/*
	 * Getters and Setters
	 */

	/**
	 * Get the contract port number.
	 * @return The contract port number.
	 */
	static public int getContractPortNumber() {
		return contractPortNumber;
	}

	/**
	 * Get the server host.
	 * @return The server host.
	 */
	static public String getServerHost() {
		return serverHost;
	}
}
