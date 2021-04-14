package rs.ac.ni.pmf.android.scoretracker2021.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import java.util.List;

import rs.ac.ni.pmf.android.scoretracker2021.R;
import rs.ac.ni.pmf.android.scoretracker2021.databinding.GamesListElementBinding;
import rs.ac.ni.pmf.android.scoretracker2021.model.Game;

public class GamesListAdapter extends BaseAdapter
{
	private final Context _context;
	private final List<Game> _games;

	public GamesListAdapter(final Context context, final List<Game> games)
	{
		_context = context;
		_games = games;
	}

	@Override
	public int getCount()
	{
		return _games.size();
	}

	@Override
	public Object getItem(final int position)
	{
		return _games.get(position);
	}

	@Override
	public long getItemId(final int position)
	{
		return _games.get(position).getId();
	}

	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent)
	{
		final LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final GamesListElementBinding binding = DataBindingUtil.inflate(inflater, R.layout.games_list_element, parent, false);
		binding.setGame((Game) getItem(position));

		return binding.getRoot();
	}
}
