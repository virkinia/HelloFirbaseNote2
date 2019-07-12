package com.example.hellofirbasenote2;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyNoteRow>  {


    private ArrayList<NotesModel> notesList;

    public NoteAdapter(ArrayList<NotesModel> notesList){

        this.notesList = notesList;
    }



    @Override
    public MyNoteRow onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row, parent, false);
        MyNoteRow viewHolder = new MyNoteRow(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyNoteRow viewHolder, int i) {
        viewHolder.title.setText(notesList.get(i).getTitle());
        viewHolder.subtitle.setText(notesList.get(i).getSubTitle());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }


    public void loadData(ArrayList<NotesModel> notesList) {
        this.notesList = notesList;
    }


    public void addNote(NotesModel note, int index) {
        this.notesList.add(index, note);
        notifyItemInserted(0);

    }

    public void deleteNote() {

        this.notesList.remove(0);
        notifyItemRemoved(0);


    }

    public void onItemDismiss(int position){
        notesList.remove(position);
        notifyDataSetChanged();
    }

    public void onItemMove(int position_dragged, int position_target){
        Collections.swap(notesList,position_dragged,position_target);
        notifyItemMoved(position_dragged,position_target);

    }





    static class MyNoteRow extends RecyclerView.ViewHolder {
        private TextView title, subtitle;


        MyNoteRow(View v) {
            super(v);
            title = v.findViewById(R.id.title);
            subtitle = v.findViewById(R.id.subtitle);
        }


    }
}
