package com.example.conferenceapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import src.Event;
import src.SpeakerController;

public class EventsListFragment extends Fragment {
    private RecyclerView recyclerView;
    private EventCardAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<EventCard> speakingList;
    Global global;

    public EventsListFragment(Global global){
        this.global = global;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_eventslist, container, false);
        getActivity().setTitle("My Events");


        SpeakerController scon = global.getTc().getScon();
        speakingList = getEventCardList(scon.getScheduledEvents(scon.getUsername()));



        //Testing

        //Testing



        recyclerView = root.findViewById(R.id.event_recyclerview);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new EventCardAdapter(speakingList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new EventCardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                EventViewBottomSheet evbs = new EventViewBottomSheet(global, speakingList.get(position).getTitle(), speakingList.get(position).getSpeakername());
                evbs.show(getChildFragmentManager(), "eventview bottomsheet");
            }
        });

        return root;
    }

    public static ArrayList<EventCard> getEventCardList(ArrayList<Event> eventslist){
        ArrayList<EventCard> returnlist = new ArrayList<EventCard>();

        //TESTING

        //TESTING

        for(Event e : eventslist){
            returnlist.add(new EventCard(e));
        }

        return returnlist;
    }
}
