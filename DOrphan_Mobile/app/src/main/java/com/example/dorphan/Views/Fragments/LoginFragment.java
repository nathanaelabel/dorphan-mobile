package com.example.dorphan.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dorphan.Helpers.SharedPreferenceHelper;
import com.example.dorphan.R;
import com.example.dorphan.ViewModels.LoginViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    private TextInputLayout textInputLayoutEmailFragmentLogin, textInputLayoutPasswordFragmentLogin;
    private Button buttonLoginFragmentLogin;
    private TextView textViewRegisterFragmentLogin;
    private LoginViewModel loginViewModelFragmentLogin;
    private SharedPreferenceHelper helperFragmentLogin;
    private String objEmailFragmentLogin, objPasswordFragmentLogin;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        helperFragmentLogin = SharedPreferenceHelper.getInstance(requireActivity());

        if (helperFragmentLogin.getAccessToken() != "") {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_findSkillFragment);
        } else {
            initial(view);
            loginProccess();
            goToRegisterFragment();
        }
    }

    private void goToRegisterFragment() {
        textViewRegisterFragmentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registerFragment);
            }
        });
    }

    private void loginProccess() {
        buttonLoginFragmentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                objEmailFragmentLogin = textInputLayoutEmailFragmentLogin.getEditText().getText().toString().trim();
                objPasswordFragmentLogin = textInputLayoutPasswordFragmentLogin.getEditText().getText().toString().trim();
                System.out.println("pass: "+objPasswordFragmentLogin+ objEmailFragmentLogin);
                if (!objEmailFragmentLogin.isEmpty() && !objPasswordFragmentLogin.isEmpty()) {
                    loginViewModelFragmentLogin.login(objEmailFragmentLogin, objPasswordFragmentLogin).observe(LoginFragment.this.requireActivity(), tokenResponse -> {
System.out.println("tokenku: "+tokenResponse);
                        if (tokenResponse != null) {
                            if (tokenResponse.getResult() != null) {
                                helperFragmentLogin.saveAccessToken(tokenResponse.getResult().getAuthorization());
                                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_findSkillFragment);
                                Toast.makeText(LoginFragment.this.requireActivity(), tokenResponse.getStatus(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginFragment.this.requireActivity(), tokenResponse.getStatus(), Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(LoginFragment.this.requireActivity(), "Terjadi kesalahan!", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(LoginFragment.this.requireActivity(), "Silakan lengkapi data anda!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initial(View view) {
        textInputLayoutEmailFragmentLogin = getActivity().findViewById(R.id.textInputLayoutEmailFragmentLogin);
        textInputLayoutPasswordFragmentLogin = getActivity().findViewById(R.id.textInputLayoutPasswordFragmentLogin);
        buttonLoginFragmentLogin = getActivity().findViewById(R.id.buttonLoginFragmentLogin);
        textViewRegisterFragmentLogin = view.findViewById(R.id.textViewRegisterFragmentLogin);

        loginViewModelFragmentLogin = new ViewModelProvider(getActivity()).get(LoginViewModel.class);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}
