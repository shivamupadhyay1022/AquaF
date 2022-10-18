package com.su.aquaf.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.su.aquaf.R;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QueryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QueryFragment extends Fragment implements View.OnClickListener {

    private EditText email;
    private EditText query;
    private EditText name;
    private Button btn_query;

    TextInputLayout lay_branch;
    AutoCompleteTextView act_branch;

    ArrayList<String> arraylist_branch;
    ArrayAdapter<String> arrayAdapter_branch;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QueryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QueryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QueryFragment newInstance(String param1, String param2) {
        QueryFragment fragment = new QueryFragment();
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
        View view = inflater.inflate(R.layout.fragment_query, container, false);


        email = view.findViewById(R.id.email);
        query = view.findViewById(R.id.login_query);
        btn_query = view.findViewById(R.id.btn_query1);
        name = view.findViewById(R.id.login_name);

        lay_branch = (TextInputLayout) view.findViewById(R.id.layout_branch);
        act_branch = (AutoCompleteTextView) view.findViewById(R.id.select_branch);

        arraylist_branch = new ArrayList<>();
        arraylist_branch.add("Individual");
        arraylist_branch.add("Buissnes");


        arrayAdapter_branch = new ArrayAdapter<>(getContext(), R.layout.dropdownlist, arraylist_branch);
        act_branch.setAdapter(arrayAdapter_branch);

        act_branch.setThreshold(1);


        btn_query.setOnClickListener(this);


        return view;

    }

    @Override
    public void onClick(View v) {
        String txt_email = email.getText().toString().trim();
        String txt_query = query.getText().toString().trim();
        String txt_name = name.getText().toString().trim();
        String txt_branch = act_branch.getText().toString().trim();

        if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_query) || TextUtils.isEmpty(txt_name)) {
            Toast.makeText(getContext(), "Empty credentials!", Toast.LENGTH_SHORT).show();
        } else {

            Intent selectorIntent = new Intent(Intent.ACTION_SENDTO);
            selectorIntent.setData(Uri.parse("mailto:"));

            final Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"araquaformatics@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Query - " + txt_branch);
            emailIntent.putExtra(Intent.EXTRA_TEXT, txt_query);
            emailIntent.setSelector(selectorIntent);

            getActivity().startActivity(Intent.createChooser(emailIntent, "Send email..."));

            HomeFragment homeFrag = new HomeFragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, homeFrag)
                    .commit();


        }
    }
}