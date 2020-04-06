import java.util.Optional;

public class Yatzy {

	protected static int[] dice = new int[5];

	public Yatzy(int[] de) {
		for (int i = 0; i <= dice.length-1; i++) {
			dice[i] = de[i];

		}
	}

	// Calcul du total lors du lancé de nos dés
	public static int chance(int[] dice) {
		int total = 0;

		for (int i = 0; i <= dice.length-1; i++) {
			total += dice[i];
		}
		return total;
	}

	// Cas ou nous avons les dés de la meme face
	public static int yatzy(int[] dice) {
		int[] counts = new int[6];
		for (int die : dice)
			counts[die - 1]++;
		for (int i = 0; i <= 5; i++)
			if (counts[i] == 5)
				return 50;
		return 0;

	}

	// methode permettant l'addition des faces
	public static int oneTwoThreesfoursFivesSixes(int a, Optional<int[]> tableau) {
		int sum = 0;
		for (int i = 0; i <= dice.length-1; i++) {
			if (tableau.isPresent()) {
				if (tableau.get()[i] == a)
					sum += a;
			} else {

				if (dice[i] == a)
					sum += a;
			}
		}
		return sum;

	}

	// methode permettant de determiner la petite suite et la grande suite
	public static int smallStraightLarge(int a, int... dice) {
		int[] counts = new int[6];
		for (int i = 0; i <= dice.length-1; i++)
			counts[dice[i] - 1]++;
		if (a == 15) {
			if (counts[0] == 1 && counts[1] == 1 && counts[2] == 1 && counts[3] == 1 && counts[4] == 1)
				return a;
		} else if (a == 20) {
			if (counts[1] == 1 && counts[2] == 1 && counts[3] == 1 && counts[4] == 1 && counts[5] == 1)
				return 20;
		}
		return 0;

	}

	// methode permettant de determiner les carrés
	public static int four_of_a_kindThree_of_a_kind(int a, int[] dice) {
		int[] counts = new int[6];
		for (int i = 0; i <= dice.length-1; i++)
			counts[dice[i] - 1]++;
		for (int i = 0; i < 6; i++)
			if (counts[i] >= a)
				return (i + 1) * a;
		return 0;
	}

	// methode permettant de savoir si le joueur a fait un full
	public static int fullHouse(int[] dice) {
		boolean _2 = false;
		int i;
		int _2_at = 0;
		boolean _3 = false;
		int _3_at = 0;
		int[] counts = new int[6];
		for (int j = 0; j <= dice.length-1; j++)
			counts[dice[j] - 1]++;
		for (i = 0; i != 6; i++)
			if (counts[i] == 2) {
				_2 = true;
				_2_at = i + 1;
			}
		for (i = 0; i != 6; i += 1)
			if (counts[i] == 3) {
				_3 = true;
				_3_at = i + 1;
			}

		if (_2 && _3)
			return _2_at * 2 + _3_at * 3;
		else
			return 0;
	}

	// methode permettant de determiner le score sur les paires
	public static int scoreSurPaire(int[] tableau, boolean verif) {

		int[] counts = new int[6];
		int n = 0;
		int score = 0;
		for (int i = 0; i <= dice.length-1; i++)
			counts[tableau[i] - 1]++;
		for (int at = 0; at != dice.length; at++) {
			if (counts[6 - at - 1] >= 2) {
				if (verif) {
					return (6 - at) * 2;
				} else {
					n++;
					score += (6 - at);
				}
				if (n == 2)
					return score * 2;
			}
		}
		return 0;

	}

	public static int ones(int[] dice) {
		return oneTwoThreesfoursFivesSixes(1, Optional.of(dice));
	}

	public static int twos(int[] dice) {
		return oneTwoThreesfoursFivesSixes(2, Optional.of(dice));
	}

	public static int threes(int[] dice) {
		return oneTwoThreesfoursFivesSixes(3, Optional.of(dice));
	}

	public int fours() {
		return oneTwoThreesfoursFivesSixes(4, Optional.empty());
	}

	public int fives() {
		return oneTwoThreesfoursFivesSixes(5, Optional.empty());
	}

	public int sixes() {
		return oneTwoThreesfoursFivesSixes(6, Optional.empty());
	}

	public static int score_pair(int[] dice) {

		return scoreSurPaire(dice, true);
	}

	public static int two_pair(int[] dice) {
		return scoreSurPaire(dice, false);

	}

	public static int four_of_a_kind(int[] dice) {
		return four_of_a_kindThree_of_a_kind(4, dice);
	}

	public static int three_of_a_kind(int... dice) {
		return four_of_a_kindThree_of_a_kind(3, dice);

	}

	public static int smallStraight(int... dice) {
		return smallStraightLarge(15, dice);
	}

	public static int largeStraight(int... dice) {
		return smallStraightLarge(20, dice);

	}

}
