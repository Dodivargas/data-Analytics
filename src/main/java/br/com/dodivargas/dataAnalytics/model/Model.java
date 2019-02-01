package br.com.dodivargas.dataAnalytics.model;

import java.util.regex.Matcher;

public interface Model {
    Model parse(Matcher matcher);
}
