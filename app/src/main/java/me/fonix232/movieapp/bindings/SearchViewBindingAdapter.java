package me.fonix232.movieapp.bindings;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods({
        @BindingMethod(type = SearchView.class, attribute = "android:onQueryTextFocusChange", method = "setOnQueryTextFocusChangeListener"),
        @BindingMethod(type = SearchView.class, attribute = "android:onSearchClick", method = "setOnSearchClickListener"),
        @BindingMethod(type = SearchView.class, attribute = "android:onClose", method = "setOnCloseListener"),
})
public class SearchViewBindingAdapter {
    @BindingAdapter("android:onQueryTextChange")
    public static void setListener(SearchView view, androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextChange listener) {
        setListener(view, null, listener);
    }

    @BindingAdapter("android:onQueryTextSubmit")
    public static void setListener(SearchView view, androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit listener) {
        setListener(view, listener, null);
    }

    @BindingAdapter({"android:onQueryTextSubmit", "android:onQueryTextChange"})
    public static void setListener(SearchView view, final androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit submit, final androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextChange change) {
        if (submit == null && change == null) {
            view.setOnQueryTextListener(null);
        } else {
            view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    if (submit != null) {
                        return submit.onQueryTextSubmit(query);
                    } else {
                        return false;
                    }
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    if (change != null) {
                        return change.onQueryTextChange(newText);
                    } else {
                        return false;
                    }
                }
            });
        }
    }

    @BindingAdapter("android:onSuggestionClick")
    public static void setListener(SearchView view, androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionClick listener) {
        setListener(view, null, listener);
    }

    @BindingAdapter("android:onSuggestionSelect")
    public static void setListener(SearchView view, androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionSelect listener) {
        setListener(view, listener, null);
    }

    @BindingAdapter({"android:onSuggestionSelect", "android:onSuggestionClick"})
    public static void setListener(SearchView view, final androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionSelect submit, final androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionClick change) {
            if (submit == null && change == null) {
                view.setOnSuggestionListener(null);
            } else {
                view.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
                    @Override
                    public boolean onSuggestionSelect(int position) {
                        if (submit != null) {
                            return submit.onSuggestionSelect(position);
                        } else {
                            return false;
                        }
                    }

                    @Override
                    public boolean onSuggestionClick(int position) {
                        if (change != null) {
                            return change.onSuggestionClick(position);
                        } else {
                            return false;
                        }
                    }
                });
            }
    }
}
