package de.goatfryed.pm.battleships.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Shot  
{

   public static final String PROPERTY_column = "column";

   private int column;

   public int getColumn()
   {
      return column;
   }

   public Shot setColumn(int value)
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

   public Shot setRow(String value)
   {
      if (value == null ? this.row != null : ! value.equals(this.row))
      {
         String oldValue = this.row;
         this.row = value;
         firePropertyChange("row", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_player = "player";

   private Player player = null;

   public Player getPlayer()
   {
      return this.player;
   }

   public Shot setPlayer(Player value)
   {
      if (this.player != value)
      {
         Player oldValue = this.player;
         if (this.player != null)
         {
            this.player = null;
            oldValue.withoutShots(this);
         }
         this.player = value;
         if (value != null)
         {
            value.withShots(this);
         }
         firePropertyChange("player", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_hit = "hit";

   private Section hit = null;

   public Section getHit()
   {
      return this.hit;
   }

   public Shot setHit(Section value)
   {
      if (this.hit != value)
      {
         Section oldValue = this.hit;
         if (this.hit != null)
         {
            this.hit = null;
            oldValue.setShotBy(null);
         }
         this.hit = value;
         if (value != null)
         {
            value.setShotBy(this);
         }
         firePropertyChange("hit", oldValue, value);
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
      this.setPlayer(null);
      this.setHit(null);

   }


}