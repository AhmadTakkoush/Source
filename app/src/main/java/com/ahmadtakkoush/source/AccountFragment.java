package com.ahmadtakkoush.source;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ImageView avatarIv;
    TextView nameTv, emailTv;


    private RecyclerView mRecyclerView;
    //adapter provides as many items as we need currently
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public AccountFragment() {
        // Required empty public constructor
    }

    //public void onCreate(Bundle savedInstanceState) {


    //}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //Array of settings items
        ArrayList<SettingsItem> settingsItems = new ArrayList<>();
        settingsItems.add(new SettingsItem(R.drawable.ic_add_image, "Line1a", "Line 2d"));
        settingsItems.add(new SettingsItem(R.drawable.ic_add_image, "Line2b", "Line 2e"));
        settingsItems.add(new SettingsItem(R.drawable.ic_add_image, "Line3c", "Line 2f"));

        mRecyclerView.findViewById(R.id.SettingsList); //?? Ahmad
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mAdapter = new SettingsAdapter(settingsItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        View view = inflater.inflate(R.layout.fragment_account, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        avatarIv = view.findViewById(R.id.avatarIv);
        nameTv = view.findViewById(R.id.nameTv);
        emailTv = view.findViewById(R.id.emailTv);

        Query query = databaseReference.orderByChild("email").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren())
                {
                    String name = "" + ds.child("name").getValue();
                    String email = "" + ds.child("email").getValue();
                    String image = "" + ds.child("image").getValue();

                    nameTv.setText(name);
                    emailTv.setText(email);
                    try{
                        Picasso.get().load(image).into(avatarIv);
                        }
                    catch (Exception e)
                    {
                        Picasso.get().load(R.drawable.ic_add_image).into(avatarIv);
                    }

                }

            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });


        return view;
    }

}
