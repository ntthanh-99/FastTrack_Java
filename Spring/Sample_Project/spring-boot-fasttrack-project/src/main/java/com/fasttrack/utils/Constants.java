package com.fasttrack.utils;

import java.util.Locale;
import lombok.experimental.UtilityClass;


@UtilityClass
public final class Constants {

  public static final String DEFAULT_ENCODING = "UTF-8";

  public static final Locale TURKISH_LOCALE = new Locale.Builder().setLanguage("tr").setRegion("TR")
      .build();

}
