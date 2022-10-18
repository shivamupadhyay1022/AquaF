package com.su.aquaf.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.su.aquaf.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        TextView pn1 = view.findViewById(R.id.frag_contact_pn1);
        SpannableString content1 = new SpannableString("+919911498738");
        content1.setSpan(new UnderlineSpan(), 0, content1.length(), 0);
        pn1.setText(content1);
        pn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:+919911498738"));
                startActivity(intent1);
            }
        });
        TextView pn2 = (TextView) view.findViewById(R.id.frag_contact_pn2);
        SpannableString content2 = new SpannableString("+917982361289");
        content2.setSpan(new UnderlineSpan(), 0, content2.length(), 0);
        pn2.setText(content2);
        pn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:+917982361289"));
                startActivity(intent2);
            }
        });

        TextView em1 = (TextView) view.findViewById(R.id.frag_contact_em1);
        SpannableString content3 = new SpannableString("araquaformatics@gmail.com");
        content3.setSpan(new UnderlineSpan(), 0, content3.length(), 0);
        em1.setText(content3);
        em1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "araquaformatics@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Information");
                intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                startActivity(intent);
            }
        });

        return view;
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.frag_contact_pn1:
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:0123456789"));
//                startActivity(intent);
//                break;
//            case R.id.frag_contact_pn2:
//
//
//                break;
//
//            default:
//                break;
//        }
//    }
}