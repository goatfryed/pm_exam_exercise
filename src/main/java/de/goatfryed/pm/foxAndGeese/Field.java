package de.goatfryed.pm.foxAndGeese;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Field 
{

   public static final String PROPERTY_meeple = "meeple";

   private Meeple meeple = null;

   public Meeple getMeeple()
   {
      return this.meeple;
   }

   public Field setMeeple(Meeple value)
   {
      if (this.meeple != value)
      {
         Meeple oldValue = this.meeple;
         if (this.meeple != null)
         {
            this.meeple = null;
            oldValue.setField(null);
         }
         this.meeple = value;
         if (value != null)
         {
            value.setField(this);
         }
         firePropertyChange("meeple", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_south = "south";

   private Field south = null;

   public Field getSouth()
   {
      return this.south;
   }

   public Field setSouth(Field value)
   {
      if (this.south != value)
      {
         Field oldValue = this.south;
         if (this.south != null)
         {
            this.south = null;
            oldValue.setNorth(null);
         }
         this.south = value;
         if (value != null)
         {
            value.setNorth(this);
         }
         firePropertyChange("south", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_north = "north";

   private Field north = null;

   public Field getNorth()
   {
      return this.north;
   }

   public Field setNorth(Field value)
   {
      if (this.north != value)
      {
         Field oldValue = this.north;
         if (this.north != null)
         {
            this.north = null;
            oldValue.setSouth(null);
         }
         this.north = value;
         if (value != null)
         {
            value.setSouth(this);
         }
         firePropertyChange("north", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_west = "west";

   private Field west = null;

   public Field getWest()
   {
      return this.west;
   }

   public Field setWest(Field value)
   {
      if (this.west != value)
      {
         Field oldValue = this.west;
         if (this.west != null)
         {
            this.west = null;
            oldValue.setEast(null);
         }
         this.west = value;
         if (value != null)
         {
            value.setEast(this);
         }
         firePropertyChange("west", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_east = "east";

   private Field east = null;

   public Field getEast()
   {
      return this.east;
   }

   public Field setEast(Field value)
   {
      if (this.east != value)
      {
         Field oldValue = this.east;
         if (this.east != null)
         {
            this.east = null;
            oldValue.setWest(null);
         }
         this.east = value;
         if (value != null)
         {
            value.setWest(this);
         }
         firePropertyChange("east", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_northeast = "northeast";

   private Field northeast = null;

   public Field getNortheast()
   {
      return this.northeast;
   }

   public Field setNortheast(Field value)
   {
      if (this.northeast != value)
      {
         Field oldValue = this.northeast;
         if (this.northeast != null)
         {
            this.northeast = null;
            oldValue.setSouthwest(null);
         }
         this.northeast = value;
         if (value != null)
         {
            value.setSouthwest(this);
         }
         firePropertyChange("northeast", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_southwest = "southwest";

   private Field southwest = null;

   public Field getSouthwest()
   {
      return this.southwest;
   }

   public Field setSouthwest(Field value)
   {
      if (this.southwest != value)
      {
         Field oldValue = this.southwest;
         if (this.southwest != null)
         {
            this.southwest = null;
            oldValue.setNortheast(null);
         }
         this.southwest = value;
         if (value != null)
         {
            value.setNortheast(this);
         }
         firePropertyChange("southwest", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_northwest = "northwest";

   private Field northwest = null;

   public Field getNorthwest()
   {
      return this.northwest;
   }

   public Field setNorthwest(Field value)
   {
      if (this.northwest != value)
      {
         Field oldValue = this.northwest;
         if (this.northwest != null)
         {
            this.northwest = null;
            oldValue.setSoutheast(null);
         }
         this.northwest = value;
         if (value != null)
         {
            value.setSoutheast(this);
         }
         firePropertyChange("northwest", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_southeast = "southeast";

   private Field southeast = null;

   public Field getSoutheast()
   {
      return this.southeast;
   }

   public Field setSoutheast(Field value)
   {
      if (this.southeast != value)
      {
         Field oldValue = this.southeast;
         if (this.southeast != null)
         {
            this.southeast = null;
            oldValue.setNorthwest(null);
         }
         this.southeast = value;
         if (value != null)
         {
            value.setNorthwest(this);
         }
         firePropertyChange("southeast", oldValue, value);
      }
      return this;
   }



   protected PropertyChangeSupport listeners = null;

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (listeners != null)
      {
         listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public boolean addPropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(listener);
      return true;
   }

   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(propertyName, listener);
      return true;
   }

   public boolean removePropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(listener);
      }
      return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(propertyName, listener);
      }
      return true;
   }



   public void removeYou()
   {
      this.setMeeple(null);
      this.setSouth(null);
      this.setNorth(null);
      this.setWest(null);
      this.setEast(null);
      this.setNortheast(null);
      this.setSouthwest(null);
      this.setNorthwest(null);
      this.setSoutheast(null);

   }


}