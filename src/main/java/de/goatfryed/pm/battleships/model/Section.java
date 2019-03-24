package de.goatfryed.pm.battleships.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Section  
{

   public static final String PROPERTY_column = "column";

   private int column;

   public int getColumn()
   {
      return column;
   }

   public Section setColumn(int value)
   {
      if (value != this.column)
      {
         int oldValue = this.column;
         this.column = value;
         firePropertyChange("column", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_row = "row";

   private String row;

   public String getRow()
   {
      return row;
   }

   public Section setRow(String value)
   {
      if (value == null ? this.row != null : ! value.equals(this.row))
      {
         String oldValue = this.row;
         this.row = value;
         firePropertyChange("row", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_boat = "boat";

   private Boat boat = null;

   public Boat getBoat()
   {
      return this.boat;
   }

   public Section setBoat(Boat value)
   {
      if (this.boat != value)
      {
         Boat oldValue = this.boat;
         if (this.boat != null)
         {
            this.boat = null;
            oldValue.withoutSections(this);
         }
         this.boat = value;
         if (value != null)
         {
            value.withSections(this);
         }
         firePropertyChange("boat", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_shotBy = "shotBy";

   private Shot shotBy = null;

   public Shot getShotBy()
   {
      return this.shotBy;
   }

   public Section setShotBy(Shot value)
   {
      if (this.shotBy != value)
      {
         Shot oldValue = this.shotBy;
         if (this.shotBy != null)
         {
            this.shotBy = null;
            oldValue.setHit(null);
         }
         this.shotBy = value;
         if (value != null)
         {
            value.setHit(this);
         }
         firePropertyChange("shotBy", oldValue, value);
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

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getRow());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setBoat(null);
      this.setPlayer(null);
      this.setShotBy(null);

   }


   public static final String PROPERTY_player = "player";

   private Player player = null;

   public Player getPlayer()
   {
      return this.player;
   }

   public Section setPlayer(Player value)
   {
      if (this.player != value)
      {
         Player oldValue = this.player;
         if (this.player != null)
         {
            this.player = null;
            oldValue.withoutSections(this);
         }
         this.player = value;
         if (value != null)
         {
            value.withSections(this);
         }
         firePropertyChange("player", oldValue, value);
      }
      return this;
   }



}