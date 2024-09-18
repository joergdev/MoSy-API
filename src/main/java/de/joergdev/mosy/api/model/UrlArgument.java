package de.joergdev.mosy.api.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import de.joergdev.mosy.api.model.core.AbstractModel;
import de.joergdev.mosy.shared.Utils;

public class UrlArgument extends AbstractModel implements Cloneable
{
  private String key;
  private String value;

  public UrlArgument()
  {

  }

  public UrlArgument(String key, String value)
  {
    this.key = key;
    this.value = value;
  }

  public static String getUrlPartForUrlArguments(Map<String, List<String>> map)
  {
    return getUrlPartForUrlArguments(getUrlArgumentsFromMap(map));
  }

  public static Collection<UrlArgument> getUrlArgumentsFromMap(Map<String, List<String>> map)
  {
    Collection<UrlArgument> col = new ArrayList<>();

    if (map != null)
    {
      for (Entry<String, List<String>> mapEntry : map.entrySet())
      {
        if (Utils.isCollectionEmpty(mapEntry.getValue()))
        {
          col.add(new UrlArgument(mapEntry.getKey(), null));
        }
        else
        {
          for (String queryParamVal : mapEntry.getValue())
          {
            col.add(new UrlArgument(mapEntry.getKey(), queryParamVal));
          }
        }
      }
    }

    return col;
  }

  public static String getUrlPartForUrlArguments(Collection<UrlArgument> col)
  {
    String urlPart = "";

    if (!Utils.isCollectionEmpty(col))
    {
      boolean first = true;

      for (UrlArgument urlArgument : col)
      {
        urlPart = addUrlArgumentToUrlPart(urlArgument, urlPart, first);

        first = false;
      }
    }

    return urlPart;
  }

  private static String addUrlArgumentToUrlPart(UrlArgument urlArgument, String urlPart, boolean first)
  {
    urlPart += first ? "?" : "&";

    urlPart += urlArgument.key;

    if (!Utils.isEmpty(urlArgument.value))
    {
      urlPart += "=" + urlArgument.value;
    }

    return urlPart;
  }

  public String getKey()
  {
    return key;
  }

  public void setKey(String key)
  {
    this.key = key;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  @Override
  public UrlArgument clone()
  {
    return new UrlArgument(key, value);
  }
}
