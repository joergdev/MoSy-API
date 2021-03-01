package de.joergdev.mosy.api.model;

import java.util.Arrays;

public enum InterfaceType
{
  SOAP(1, true, true),
    REST(2, true, true),
    CUSTOM_XML(3, false, false),
    CUSTOM_JSON(4, false, false),
    CUSTOM_PLAIN(5, false, false);

  public final Integer id;
  public final boolean directRoutingPossible;
  public final boolean servicePathSettable;

  private InterfaceType(Integer id, boolean directRoutingPossible, boolean servicePathSettable)
  {
    this.id = id;
    this.directRoutingPossible = directRoutingPossible;
    this.servicePathSettable = servicePathSettable;
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