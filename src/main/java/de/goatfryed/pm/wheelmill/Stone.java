package de.goatfryed.pm.wheelmill;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Stone  
{

   public static final String PROPERTY_player = "player";

   private Player player = null;

   public Player getPlayer()
   {
      return this.player;
   }

   public Stone setPlayer(Player value)
   {
      if (this.player != value)
      {
         Player oldValue = this.player;
         if (this.player != null)
         {
            this.player = null;
            oldValue.withoutStones(this);
         }
         this.player = value;
         if (value != null)
         {
            value.withStones(this);
         }
         firePropertyChange("player", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_on = "on";

   private Place on = null;

   public Place getOn()
   {
      return this.on;
   }

   public Stone setOn(Place value)
   {
      if (this.on != value)
      {
         Place oldValue = this.on;
         if (this.on != null)
         {
            this.on = null;
            oldValue.setOccupiedBy(null);
         }
         this.on = value;
         if (value != null)
         {
            value.setOccupiedBy(this);
         }
         firePropertyChange("on", oldValue, value);
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
      this.setOn(null);

   }


















}