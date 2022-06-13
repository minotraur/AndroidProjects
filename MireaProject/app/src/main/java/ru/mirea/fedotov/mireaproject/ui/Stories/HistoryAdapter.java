package ru.mirea.fedotov.mireaproject.ui.Stories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mirea.fedotov.mireaproject.R;

import java.util.List;

public class HistoryAdapter  extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<History> states;

    HistoryAdapter(Context context, List<History> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.ViewHolder holder, int position) {
        History state = states.get(position);
        holder.history.setText(state.getHistoryResource());
        holder.nameView.setText(state.getNameHistory());
        holder.author.setText(state.getAuthor());
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView history;
        final TextView nameView, author;
        ViewHolder(View view){
            super(view);
            history = view.findViewById(R.id.historylist);
            nameView = view.findViewById(R.id.name);
            author = view.findViewById(R.id.author);
        }
    }
}