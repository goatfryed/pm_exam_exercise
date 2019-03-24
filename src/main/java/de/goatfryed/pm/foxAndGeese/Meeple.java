package de.goatfryed.pm.foxAndGeese;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Meeple 
{

   public static final String PROPERTY_player = "player";

   private Player player = null;

   public Player getPlayer()
   {
      return this.player;
   }

   public Meeple setPlayer(Player value)
   {
      if (this.player != value)
      {
         Player oldValue = this.player;
         if (this.player != null)
         {
            this.player = null;
            oldValue.withoutMeeples(this);
         }
         this.player = value;
         if (value != null)
         {
            value.withMeeples(this);
         }
         firePropertyChange("player", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_field = "field";

   private Field field = null;

   public Field getField()
   {
      return this.field;
   }

   public Meeple setField(Field value)
   {
      if (this.field != value)
      {
         Field oldValue = this.field;
         if (this.field != null)
         {
            this.field = null;
            oldValue.setMeeple(null);
         }
         this.field = value;
         if (value != null)
         {
            value.setMeeple(this);
         }
         firePropertyChange("field", oldValue, value);
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
      this.setPlayer(null);
      this.setField(null);

   }


}