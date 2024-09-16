package com.example.subscribermqtt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfigActivity extends AppCompatActivity {

    private EditText editTextBroker, editTextPort, editTextTopic, editTextSeuil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        editTextBroker = findViewById(R.id.editTextBroker);
        editTextPort = findViewById(R.id.editTextPort);
        editTextTopic = findViewById(R.id.editTextTopic);
        editTextSeuil = findViewById(R.id.editTextSeuil);

        Button btnSaveConfig = findViewById(R.id.btnSaveConfig);
        btnSaveConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveConfiguration();
            }
        });
    }

    private void saveConfiguration() {

        String broker = editTextBroker.getText().toString();
        int port = Integer.parseInt(editTextPort.getText().toString());
        String topic = editTextTopic.getText().toString();
        double seuil = Double.parseDouble(editTextSeuil.getText().toString());


        SharedPreferences preferences = getSharedPreferences("config", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("broker", broker);
        editor.putInt("port", port);
        editor.putString("topic", topic);
        editor.putFloat("seuil", (float) seuil);
        editor.apply();

        Intent intent = new Intent(ConfigActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
