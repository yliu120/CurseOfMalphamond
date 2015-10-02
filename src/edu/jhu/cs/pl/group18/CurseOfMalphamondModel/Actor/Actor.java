/**
 *
 */
package edu.jhu.cs.pl.group18.CurseOfMalphamondModel.Actor;

/**
 * This class provide a super class interface for all the actors in the game.
 * Here we enclose the common attributes for all kinds of the actors in the game.
 * @author Vincent Yan, Andy Yang , Yijie Li , Xuchen Ma, Yunlong Liu
 *
 */
public abstract class Actor {
	
	protected int maxHealth;
	protected int health;
	protected int attack;
	protected int defense;
	protected String name;
	
	/**
	 * Get the maximum health of the player.
	 * @return maxHealth the max health
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	
	/**
	 * Set the maximum health of the player.
	 * @param maxHealth The maximum health
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	/**
	 * Get the health of the actor.
	 * @return health the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Set the health of the actor.
	 * @param health The health
	 */
	public void setHealth(int health) {
		if (health < 0) {
			this.health = 0;
		} else if ( health > this.maxHealth ) {
			this.health = this.maxHealth;
		} else {
			this.health = health;
		}
	}

	/**
	 * Get the attack of the actor.
	 * @return attack the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Set the attack of the actor.
	 * @param attack The attack
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	/**
	 * Get the defense of the actor.
	 * @return defense the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Set the defense of the actor.
	 * @param defense The defense
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * Get the name of the actor.
	 * @return name of the actor.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the actor.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Default Constructor
	 */
	public Actor() {
	}
	
	/**
	 * Constructor
	 */
	public Actor(int maxHealth, int attack, int defense, String name) {
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.attack = attack;
		this.defense = defense;
		this.name = name;
	}

	/**
	 * A common method that all actors should have - attack
	 * @param target the one that this actor attacks.
	 */
	public String attack(Actor target){
		//TODO implements critical hit
		//Random rand = new Random();
		//int randomNum = rand.nextInt(3);
		int realAttack = this.attack - target.getDefense();// + randomNum;
		if ( realAttack > 0 ) {
			target.setHealth(target.getHealth() - realAttack);
		} else {
			realAttack = 0;
		}
		return this.name + " attacks " + target.getName() + " and deals " + realAttack + " damage!\n";
	}
	
	/**
	 * A common method that all actors should have - to tell whether this actor is dead.
	 * @return a boolean value that indicates dead or not.
	 */
	public boolean isDead(){
		return health <= 0;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attack;
		result = prime * result + defense;
		result = prime * result + health;
		result = prime * result + maxHealth;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (attack != other.attack)
			return false;
		if (defense != other.defense)
			return false;
		if (health != other.health)
			return false;
		if (maxHealth != other.maxHealth)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
