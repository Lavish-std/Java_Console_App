package character;

import race.*;
import job.*;
import java.util.*;

	public abstract class Character {

		private final String name;
		private final Race race;
		private final JobClass job;

		private int health;
		private int mana;
		private int xp;
		private int level;
		private final List<Item> inventory;
		private final int maxHealth;

		public Character(String name, Race race, JobClass job, int health, int mana, int level, int xp, List<Item> inventory) {
			this.name = name;
			this.race = race;
			this.job = job;
			this.health = health;
			this.maxHealth = health; // assuming starting health is full HP
			this.mana = mana;
			this.level = level;
			this.xp = xp;
			this.inventory = inventory;
		}

		// Getters
		public String getName() {
			return name;
		}

		public Race getRace() {
			return race;
		}

		public JobClass getJob() {
			return job;
		}

		public int getHealth() {
			return health;
		}

		public int getMana() {
			return mana;
		}

		public int getLevel() {
			return level;
		}

		public int getXp() {
			return xp;
		}

		public List<Item> getInventory() {
			return inventory;
		}

		public int getMaxHealth() {
			return maxHealth;
		}

		// Setters (only for mutable fields)
		public void setHealth(int health) {
			this.health = health;
		}

		public void setMana(int mana) {
			this.mana = mana;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public void setXp(int xp) {
			this.xp = xp;
		}

		// Abstract methods
		public abstract void attack();
		public abstract void defend();
		public abstract void useSkill();
		public abstract void getDamage(int damage);

		// Heal method
		public void heal(Item potion) {
			if (potion != null && "Potion".equalsIgnoreCase(potion.getType())) {
				int healAmount = potion.getValue();
				health = Math.min(health + healAmount, maxHealth);
				System.out.println(name + " healed for " + healAmount + " HP.");
			} else {
				System.out.println("Cannot use this item to heal!");
			}
		}

		// Level up logic
		public void levelUp(int xpAmount) {
			xp += xpAmount;
			while (xp >= level * 10) {
				xp -= level * 10;
				level++;
				System.out.println(name + " leveled up! Now at level " + level);
			}
		}

		public boolean isAlive() {
			return health > 0;
		}

		public String getStatus() {
			StringBuilder status = new StringBuilder();

			status.append("Name: ").append(name).append(" | ");
			status.append("Race: ").append(race != null ? race.getRaceName() : "Unknown").append(" | ");
			status.append("Job: ").append(job != null ? job.getJobName() : "Unknown").append(" | ");
			status.append("HP: ").append(health).append(" | ");
			status.append("MP: ").append(mana).append(" | ");
			status.append("XP: ").append(xp).append(" | ");
			status.append("Level: ").append(level).append(" | ");
			status.append("Inventory: ").append(inventory != null ? inventory : "[]");

			return status.toString();
		}
	}



