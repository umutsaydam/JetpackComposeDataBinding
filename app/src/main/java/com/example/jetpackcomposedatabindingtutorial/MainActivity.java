package com.example.jetpackcomposedatabindingtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.example.jetpackcomposedatabindingtutorial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Person sınıfından bir nesne oluşturalım.
        Person person = new Person("umut");
        /*
          -- Data Binding'i etkinleştirdiğimizden dolayı kendisi MainActivity için
             otomatik bir Binding sınıfı oluşturmakta.
          -- Otomatik oluşturulan Binding nesnesinin ismi oluşturulan Fragment/Activity'nin
             isminin tersten yazılmış hali + Binding şeklindedir.
          -- Örneğin -> MainActivity -> ActivityMainBinding gibi.
        */
        ActivityMainBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        // Person sınıfından türetilen person nesnesini binding'e atayalım.
        binding.setPerson(person);
        /*
          -- Butona tıkladığında Person sınıfının name değişkenini güncellemesi
             işlemini gerçekleştirelim.
         */
        binding.button.setOnClickListener(view -> {
            person.setName(binding.edtTxtName.getText().toString());
        });
    }
}