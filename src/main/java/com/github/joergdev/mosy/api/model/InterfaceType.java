package com.github.joergdev.mosy.api.model;

import java.util.Arrays;

public enum InterfaceType
{
  SOAP(1, true), REST(2, true), CUSTOM_XML(3, false), CUSTOM_JSON(4, false), CUSTOM_PLAIN(5, false);

  public final Integer id;
  public final boolean routingPossible;

  private InterfaceType(Integer id, boolean routingPossible)
  {
    this.id = id;
    this.routingPossible = routingPossible;
  }

  public static InterfaceType getById(Integer id)
  {
    if (id != null)
    {
      for (InterfaceType it : InterfaceType.values())
      {
        if (id.equals(it.id))
        {
          return it;
        }
      }
    }

    return null;
  }

  public static boolean isCustomType(InterfaceType type)
  {
    return Arrays.asList(CUSTOM_XML, CUSTOM_JSON, CUSTOM_PLAIN).contains(type);
  }

  public static boolean isCustomType(Integer interfaceTypeId)
  {
    return isCustomType(getById(interfaceTypeId));
  }
}