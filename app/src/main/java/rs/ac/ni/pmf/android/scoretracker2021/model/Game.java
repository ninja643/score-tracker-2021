package rs.ac.ni.pmf.android.scoretracker2021.model;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import rs.ac.ni.pmf.android.scoretracker2021.BR;

public class Game extends BaseObservable
{
	private final Long _id;
	private final String _teamA;
	private final String _teamB;

	private int _scoreA;
	private int _scoreB;

	public Game(Long id, final String teamA, final String teamB)
	{
		_id = id;
		_teamA = teamA;
		_teamB = teamB;
	}

	public Game(final Long id, final String teamA, final String teamB, final int scoreA, final int scoreB)
	{
		_id = id;
		_teamA = teamA;
		_teamB = teamB;
		_scoreA = scoreA;
		_scoreB = scoreB;
	}

	public Long getId()
	{
		return _id;
	}

	public String getTeamA()
	{
		return _teamA;
	}

	public String getTeamB()
	{
		return _teamB;
	}

	@Bindable
	public int getScoreA()
	{
		return _scoreA;
	}

	@Bindable
	public int getScoreB()
	{
		return _scoreB;
	}

	public void addScore(final Team team, final int score)
	{
		Log.i("LOG", "Adding " + score + " points to " + team.name());
		switch (team)
		{
			case TEAM_A:
				_scoreA += score;
				notifyPropertyChanged(BR.scoreA);
				break;
			case TEAM_B:
				_scoreB += score;
				notifyPropertyChanged(BR.scoreB);
				break;
		}
	}

	public void reset()
	{
		_scoreA = 0;
		_scoreB = 0;
		notifyPropertyChanged(BR.scoreA);
		notifyPropertyChanged(BR.scoreB);
	}

	@Override
	public String toString()
	{
		return "Game{" +
				"_id=" + _id +
				", _teamA='" + _teamA + '\'' +
				", _teamB='" + _teamB + '\'' +
				", _scoreA=" + _scoreA +
				", _scoreB=" + _scoreB +
				'}';
	}

	public enum Team
	{
		TEAM_A,
		TEAM_B
	}
}
