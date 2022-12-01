package com.serkantken.sinavprojesi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickListener
{
    RecyclerView recyclerView;
    List<ButtonModel> secenekler;
    ButtonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.buttonRV);

        secenekler = new ArrayList<>();

        ButtonModel secenek1 = new ButtonModel();
        secenek1.setButtonText("Çok Kötü");
        secenek1.setPressed(false);
        secenekler.add(secenek1);

        ButtonModel secenek2 = new ButtonModel();
        secenek2.setButtonText("Kötü");
        secenek2.setPressed(false);
        secenekler.add(secenek2);

        ButtonModel secenek3 = new ButtonModel();
        secenek3.setButtonText("Eh İşte");
        secenek3.setPressed(false);
        secenekler.add(secenek3);

        ButtonModel secenek4 = new ButtonModel();
        secenek4.setButtonText("Güzel");
        secenek4.setPressed(false);
        secenekler.add(secenek4);

        ButtonModel secenek5 = new ButtonModel();
        secenek5.setButtonText("Çok Güzel");
        secenek5.setPressed(false);
        secenekler.add(secenek5);

        adapter = new ButtonAdapter(secenekler, this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(int position)
    {
        for (int i = 0; i < secenekler.size(); i++)
        {
            secenekler.get(i).setPressed(false);
        }
        secenekler.get(position).setPressed(true);
        adapter.notifyDataSetChanged();
    }
}