package com.example.housinghubv6.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.housinghubv6.Models.StudentAccountSettings;
import com.example.housinghubv6.Models.User;
import com.example.housinghubv6.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseMethods {

    private static final String TAG = "FirebaseMethods";

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private String userID;

    private Context mContext;

    StudentAccountSettings studentSettings;

    public FireBaseMethods(Context context) {
        mAuth = FirebaseAuth.getInstance();
        mContext = context;

        if(mAuth.getCurrentUser() != null){
            userID = mAuth.getCurrentUser().getUid();
        }
    }

    public boolean checkIfUsernameExists(String username, DataSnapshot datasnapshot){
        Log.d(TAG, "checkIfUsernameExists: checking if " + username + " already exists.");

        User user = new User();

        for (DataSnapshot ds: datasnapshot.getChildren()){
            Log.d(TAG, "checkIfUsernameExists: datasnapshot: " + ds);

            user.setUsername(ds.getValue(User.class).getUsername());
            Log.d(TAG, "checkIfUsernameExists: username: " + user.getUsername());

            if(StringManipulation.expandUsername(user.getUsername()).equals(username)){
                Log.d(TAG, "checkIfUsernameExists: FOUND A MATCH: " + user.getUsername());
                return true;
            }
        }
        return false;
    }

    /**
     * Firstname and lastname
     * @param email
     * @param password
     * @param firstname
     * @param lastname
     * @param phonenumber
     */
    public void registerNewEmail(final String email, String password, final String firstname, String lastname, String phonenumber,boolean isStudent, String username){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(mContext, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();

                        }
                        else if(task.isSuccessful()){
                            userID = mAuth.getCurrentUser().getUid();
                            Log.d(TAG, "onComplete: Authstate changed: " + userID);
                            Toast.makeText(mContext, R.string.auth_success,
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }

    /**
     * Firstname and lastname
     * @param email
     * @param password
     * @param firstname
     * @param lastname
     */
    public void registerNewEmail(final String email, String password, final String firstname, String lastname, boolean  isStudent, String username){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(mContext, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();

                        }
                        else if(task.isSuccessful()){
                            userID = mAuth.getCurrentUser().getUid();
                            Log.d(TAG, "onComplete: Authstate changed: " + userID);
                            Toast.makeText(mContext, R.string.auth_success,
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }

    public void addNewUser(int year, String bio, String email,String firstname, String lastname,
                           int gbp_month, int no_of_housemates, String username, String profile_photo, boolean isStudent){

        //create a new user object with the details
        User user = new User( userID,  "1",  email,  StringManipulation.condenseUsername(username), isStudent );


        myRef.child(mContext.getString(R.string.dbname_users))
                .child(userID)
                .setValue(user);


        if(isStudent){
            studentSettings = new StudentAccountSettings(
              year,
              bio,
              email,
              firstname,
              gbp_month,
              isStudent,
              lastname,
              no_of_housemates,
              profile_photo,
              username
            );
        }else{

            //make landlord account settings

        }

        //check the user type then set the settings
        if(isStudent){
            myRef.child(mContext.getString(R.string.dbname_students))
                    .child(userID)
                    .setValue(studentSettings);
        }else{
            myRef.child(mContext.getString(R.string.dbname_landlord))
                    .child(userID);
                  //  .setValue(landlord);
        }
    }
}
