package com.virliana.automatedsystem.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;
import com.virliana.automatedsystem.R;
import com.virliana.automatedsystem.app.database.Student;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentsRenderer extends Renderer<Student> {

    @BindView(R.id.tv_stud_id)
    TextView studentId;
    @BindView(R.id.tv_nfs)
    TextView nfs;
    @BindView(R.id.tv_date_of_birth)
    TextView dateOfBirth;
    @BindView(R.id.tv_email)
    TextView email;
    @BindView(R.id.tv_phone_number)
    TextView phoneNumber;
    @BindView(R.id.tv_last_changed)
    TextView lastChanged;

    private OnItemClickListener<Student> listener;

    public StudentsRenderer(OnItemClickListener<Student> listener) {
        this.listener = listener;
    }

    public static RVRendererAdapter<Student> createAdapter(OnItemClickListener<Student> listener) {
        return new RVRendererAdapter<>(new RendererBuilder<>(new StudentsRenderer(listener)));
    }

    @Override
    protected void setUpView(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    @Override
    protected void hookListeners(View rootView) {
        rootView.setOnClickListener(v -> listener.onItemClick(getContent()));
    }

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.item_student_row, parent, false);
    }

    @Override
    public void render() {
        studentId.setText((getContent().getStudent_id() == 0 ? "unknown" : getContent().getStudent_id()) + "");
        nfs.setText(getContent().getNfs() == null ? "unknown" : getContent().getNfs().toString());
        dateOfBirth.setText(getContent().getDateOfBirth() == null ? "unknown" : getContent().getDateOfBirth().toString());
        email.setText(getContent().getEmail() == null ? "unknown" : getContent().getEmail());
        phoneNumber.setText(getContent().getNumber() == null ? "unknown" : getContent().getNumber());
        lastChanged.setText(getContent().getLastChanged() == null ? "unknown" : getContent().getLastChanged().toString());
    }


}
