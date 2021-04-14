package rs.ac.ni.pmf.android.scoretracker2021.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

import rs.ac.ni.pmf.android.scoretracker2021.adapter.GamesListAdapter;
import rs.ac.ni.pmf.android.scoretracker2021.model.GamesViewModel;

public class GamesListFragment extends ListFragment
{
	private OnGameSelectedListener _gameSelectedListener;

	private GamesViewModel _gamesViewModel;

	@Override
	public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		_gamesViewModel = new ViewModelProvider(requireActivity()).get(GamesViewModel.class);
		_gamesViewModel.getGames().observe(getViewLifecycleOwner(), list -> setListAdapter(new GamesListAdapter(requireActivity(), list)));
	}

	@Override
	public void onListItemClick(@NonNull final ListView l, @NonNull final View v, final int position, final long id)
	{
		_gamesViewModel.selectGame(position);
		_gameSelectedListener.onGameSelected();
	}

	public interface OnGameSelectedListener
	{
		void onGameSelected();
	}

	@Override
	public void onAttach(@NonNull final Context context)
	{
		super.onAttach(context);
		_gameSelectedListener = (OnGameSelectedListener) context;
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
		_gameSelectedListener = null;
	}
}
