package de.joergdev.mosy.api.model;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class UrlArgumentTest
{
  @Test
  public void testGetUrlPartForUrlArguments_multiValues()
  {
    Map<String, List<String>> map = new HashMap<>();
    map.put("test", null);
    map.put("name", Arrays.asList("Hans", "Jens"));
    map.put("hello", null);

    String url = UrlArgument.getUrlPartForUrlArguments(map);
    assertEquals("?test&name=Hans&name=Jens&hello", url);
  }

  @Test
  public void testGetUrlPartForUrlArguments_singleValues()
  {
    Map<String, List<String>> map = new HashMap<>();
    map.put("wsdl", null);

    String url = UrlArgument.getUrlPartForUrlArguments(map);
    assertEquals("?wsdl", url);
  }

  @Test
  public void testGetUrlPartForUrlArguments_noValues()
  {
    Map<String, List<String>> map = new HashMap<>();

    String url = UrlArgument.getUrlPartForUrlArguments(map);
    assertEquals("", url);
  }
}
