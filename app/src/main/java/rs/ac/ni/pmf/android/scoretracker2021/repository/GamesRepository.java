package rs.ac.ni.pmf.android.scoretracker2021.repository;

import java.util.Arrays;
import java.util.List;

import rs.ac.ni.pmf.android.scoretracker2021.model.Game;

public class GamesRepository
{
	public static List<Game> games = Arrays.asList(
			new Game(1L, "Real", "CSKA"),
			new Game(2L, "Barcelona", "Unicaja"),
			new Game(3L, "Anadolu Efes", "Unicaja"),
			new Game(4L, "Barcelona", "Panathinaikos"),
			new Game(5L, "Alba Berlin", "Unicaja"),
			new Game(6L, "Barcelona", "Unicaja")
	);
}
