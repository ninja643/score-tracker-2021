package rs.ac.ni.pmf.android.scoretracker2021.fragment;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import rs.ac.ni.pmf.android.scoretracker2021.R;
import rs.ac.ni.pmf.android.scoretracker2021.databinding.GameDetailsBinding;
import rs.ac.ni.pmf.android.scoretracker2021.model.GamesViewModel;

public class GameDetailsFragment extends Fragment
{
	private GameDetailsBinding _binding;

	@Nullable
	@Override
	public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState)
	{
		_binding = DataBindingUtil.inflate(inflater, R.layout.game_details, container, false);
		return _binding.getRoot();
	}

	@Override
	public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		final GamesViewModel gamesViewModel = new ViewModelProvider(requireActivity()).get(GamesViewModel.class);
		gamesViewModel.getSelectedGame().observe(getViewLifecycleOwner(), game -> _binding.setGame(game));
	}
}
