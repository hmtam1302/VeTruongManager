package com.example.vetruongmanager.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import android.view.View.OnKeyListener;

import com.example.vetruongmanager.MainActivity;
import com.example.vetruongmanager.R;
import com.example.vetruongmanager.data.CustomTicketItemAdapter;
import com.example.vetruongmanager.data.Ticket;

import java.util.List;

import static com.example.vetruongmanager.ui.IntroActivity.ticketManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TicketListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TicketListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView ticketListView;
    private EditText searchEditText;

    public TicketListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TicketListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TicketListFragment newInstance(String param1, String param2) {
        TicketListFragment fragment = new TicketListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ticket_list, container, false);
        ticketListView = (ListView) rootView.findViewById(R.id.ticket_list);
        ticketListView.setAdapter(new CustomTicketItemAdapter(getActivity(), ticketManager.getTicketList()));

        // When the user clicks on the ListItem
        ticketListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = ticketListView.getItemAtPosition(position);
                Ticket ticket = (Ticket) o;
                Toast.makeText(getActivity(), "Selected :" + " " + ticket.getName(), Toast.LENGTH_LONG).show();
            }
        });

        searchEditText = (EditText) rootView.findViewById(R.id.search_bar);
        searchEditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    //Hide keyboard after press endter
                    InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                    //Print line on screen
                    Toast.makeText(getActivity(), searchEditText.getText(), Toast.LENGTH_SHORT).show();
                    //Remove text after press enter
                    searchEditText.setText("");
                    return true;
                }
                return false;
            }
        });
        return  rootView;
    }

}