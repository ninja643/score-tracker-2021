package rs.ac.ni.pmf.android.scoretracker2021.model;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import rs.ac.ni.pmf.android.scoretracker2021.repository.GamesRepository;

public class GamesViewModel extends ViewModel
{
	private MutableLiveData<List<Game>> _games;

	private final MutableLiveData<Game> _selectedGame = new MutableLiveData<>();

	public LiveData<Game> getSelectedGame()
	{
		return _selectedGame;
	}

	public void deselectGame()
	{
		_selectedGame.setValue(null);
	}

	public void selectGame(final int position)
	{
		_selectedGame.setValue(GamesRepository.games.get(position));
	}

	public LiveData<List<Game>> getGames()
	{
		if (_games == null)
		{
			_games = new MutableLiveData<>();
			loadGames();
		}

		return _games;
	}

	private void loadGames()
	{
		final Handler handler = new Handler(Looper.getMainLooper());
		handler.postDelayed(() -> _games.setValue(GamesRepository.games), 5000);
	}
}
