package com.easv.oe.sqlite3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SingleActivity extends Activity {

    DAO dao;
public void test(){
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("plain/text");
    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "some@email.address" });
    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
    startActivity(Intent.createChooser(intent, ""));
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        dao = DAO.getInstance();

        int index = getIntent().getExtras().getInt("index");

        BEPerson current = dao.getAll().get(index);

        TextView txtName = (TextView)findViewById(R.id.txtName);

        txtName.setText(current.m_name);
    }

    public void onClickDelete(View v)
    {
        dao = DAO.getInstance();

        int index = getIntent().getExtras().getInt("index");

        BEPerson current = dao.getAll().get(index);

        dao.deleteById(current.m_id);
test();
        finish();
    }

}
