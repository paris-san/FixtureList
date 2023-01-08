// Generated by view binder compiler. Do not edit!
package com.incrowdsports.task.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.incrowdsports.task.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FixtureLayoutBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final TextView awayName;

  @NonNull
  public final TextView awayScore;

  @NonNull
  public final TextView competition;

  @NonNull
  public final TextView dateTime;

  @NonNull
  public final TextView homeName;

  @NonNull
  public final TextView homeScore;

  @NonNull
  public final TextView period;

  @NonNull
  public final TextView venue;

  private FixtureLayoutBinding(@NonNull MaterialCardView rootView, @NonNull TextView awayName,
      @NonNull TextView awayScore, @NonNull TextView competition, @NonNull TextView dateTime,
      @NonNull TextView homeName, @NonNull TextView homeScore, @NonNull TextView period,
      @NonNull TextView venue) {
    this.rootView = rootView;
    this.awayName = awayName;
    this.awayScore = awayScore;
    this.competition = competition;
    this.dateTime = dateTime;
    this.homeName = homeName;
    this.homeScore = homeScore;
    this.period = period;
    this.venue = venue;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static FixtureLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FixtureLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fixture_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FixtureLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.awayName;
      TextView awayName = ViewBindings.findChildViewById(rootView, id);
      if (awayName == null) {
        break missingId;
      }

      id = R.id.awayScore;
      TextView awayScore = ViewBindings.findChildViewById(rootView, id);
      if (awayScore == null) {
        break missingId;
      }

      id = R.id.competition;
      TextView competition = ViewBindings.findChildViewById(rootView, id);
      if (competition == null) {
        break missingId;
      }

      id = R.id.dateTime;
      TextView dateTime = ViewBindings.findChildViewById(rootView, id);
      if (dateTime == null) {
        break missingId;
      }

      id = R.id.homeName;
      TextView homeName = ViewBindings.findChildViewById(rootView, id);
      if (homeName == null) {
        break missingId;
      }

      id = R.id.homeScore;
      TextView homeScore = ViewBindings.findChildViewById(rootView, id);
      if (homeScore == null) {
        break missingId;
      }

      id = R.id.period;
      TextView period = ViewBindings.findChildViewById(rootView, id);
      if (period == null) {
        break missingId;
      }

      id = R.id.venue;
      TextView venue = ViewBindings.findChildViewById(rootView, id);
      if (venue == null) {
        break missingId;
      }

      return new FixtureLayoutBinding((MaterialCardView) rootView, awayName, awayScore, competition,
          dateTime, homeName, homeScore, period, venue);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
