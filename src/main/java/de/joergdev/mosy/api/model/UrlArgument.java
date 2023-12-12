package de.joergdev.mosy.api.model;

import de.joergdev.mosy.api.model.core.AbstractModel;

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

  public UrlArgument clone()
  {
    return new UrlArgument(key, value);
  }
}
