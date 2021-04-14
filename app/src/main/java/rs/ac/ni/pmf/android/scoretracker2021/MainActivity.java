package rs.ac.ni.pmf.android.scoretracker2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import rs.ac.ni.pmf.android.scoretracker2021.fragment.GameDetailsFragment;
import rs.ac.ni.pmf.android.scoretracker2021.fragment.GamesListFragment;

public class MainActivity extends AppCompatActivity implements GamesListFragment.OnGameSelectedListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onGameSelected()
	{
		if (findViewById(R.id.portrait_fragment_container) != null)
		{
			getSupportFragmentManager().beginTransaction()
					.setReorderingAllowed(true)
					.replace(R.id.portrait_fragment_container, GameDetailsFragment.class, null)
					.addToBackStack(null)
					.commit();
		}
	}
}