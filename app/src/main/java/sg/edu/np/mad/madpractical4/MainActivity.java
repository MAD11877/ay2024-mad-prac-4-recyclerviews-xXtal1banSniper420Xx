package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class  MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Initialise new user object
        User user = new User("John Doe","MAD Developer", 1, false);

        //Get the TextViews and buttons from layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        //Set the TextViews with the User's name, description and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("FOLLOW");

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change to follow is user is unfollowing
                if (user.followed){
                    btnFollow.setText("FOLLOW");
                    user.followed = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                //Change to unfollow is user is following
                else if (!user.followed) {
                    btnFollow.setText("UNFOLLOW");
                    user.followed = true;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Intent receivingEnd = getIntent();
        String name = receivingEnd.getStringExtra("Name");
        String description = receivingEnd.getStringExtra("Description");
        //Set the TextViews with the User's name, description and default button message
        tvName.setText(name);
        tvDescription.setText(description);
        btnFollow.setText("FOLLOW");
    }
}