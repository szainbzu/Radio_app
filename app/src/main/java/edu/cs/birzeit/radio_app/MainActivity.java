package edu.cs.birzeit.radio_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;
    private EditText edtName, edtEmail;
    private RadioGroup rdGroup;
    private RadioButton rdMale, rdFemal;
    private Switch swLastYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        btnSave = findViewById(R.id.btnSave);
        rdGroup = findViewById(R.id.grpRadio);
        swLastYear = findViewById(R.id.swLastYear);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rdGroup.getCheckedRadioButtonId();
                if(id == -1){
                    Toast.makeText(MainActivity.this, "Nothing is selected",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    RadioButton rd = findViewById(id);
                    String msg = rd.getText().toString();
                    if(swLastYear.isChecked()){
                        msg+= ", Last Year";
                    }
                    else{
                        msg+=", not last year";
                    }
                    Toast.makeText(MainActivity.this, msg,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}