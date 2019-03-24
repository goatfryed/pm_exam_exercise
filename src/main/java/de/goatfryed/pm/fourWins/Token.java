package de.goatfryed.pm.fourWins;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Token  
{

   public static final String PROPERTY_height = "height";

   private int height;

   public int getHeight()
   {
      return height;
   }

   public Token setHeight(int value)
   {
      if (value != this.height)
      {
         int oldValue = this.height;
         this.height = value;
         firePropertyChange("height", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_player = "player";

   private Player player = null;

   public Player getPlayer()
   {
      return this.player;
   }

   public Token setPlayer(Player value)
   {
      if (this.player != value)
      {
         Player oldValue = this.player;
         if (this.player != null)
         {
            this.player = null;
            oldValue.withoutTokens(this);
         }
         this.player = value;
         if (value != null)
         {
            value.withTokens(this);
         }
         firePropertyChange("player", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_column = "column";

   private Column column = null;

   public Column getColumn()
   {
      return this.column;
   }

   public Token setColumn(Column value)
   {
      if (this.column != value)
      {
         Column oldValue = this.column;
         if (this.column != null)
         {
            this.column = null;
            oldValue.withoutTokens(this);
         }
         this.column = value;
         if (value != null)
         {
            value.withTokens(this);
         }
         firePropertyChange("column", oldValue, value);
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
      this.setColumn(null);

   }














}