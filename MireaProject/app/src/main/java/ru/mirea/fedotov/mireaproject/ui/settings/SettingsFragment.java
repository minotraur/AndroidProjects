package ru.mirea.fedotov.mireaproject.ui.settings;

import android.os.Bundle;
import android.widget.Toast;

import androidx.preference.PreferenceFragmentCompat;

import ru.mirea.fedotov.mireaproject.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        Toast.makeText(getContext(), "These are your settings", Toast.LENGTH_SHORT).show();
    }
}