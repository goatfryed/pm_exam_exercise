package de.goatfryed.pm.foxAndGeese.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Game 
{

   public static final String PROPERTY_fox = "fox";

   private Player fox = null;

   public Player getFox()
   {
      return this.fox;
   }

   public Game setFox(Player value)
   {
      if (this.fox != value)
      {
         Player oldValue = this.fox;
         if (this.fox != null)
         {
            this.fox = null;
            oldValue.setFoxOf(null);
         }
         this.fox = value;
         if (value != null)
         {
            value.setFoxOf(this);
         }
         firePropertyChange("fox", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_geese = "geese";

   private Player geese = null;

   public Player getGeese()
   {
      return this.geese;
   }

   public Game setGeese(Player value)
   {
      if (this.geese != value)
      {
         Player oldValue = this.geese;
         if (this.geese != null)
         {
            this.geese = null;
            oldValue.setGeeseOf(null);
         }
         this.geese = value;
         if (value != null)
         {
            value.setGeeseOf(this);
         }
         firePropertyChange("geese", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_currentPlayer = "currentPlayer";

   private Player currentPlayer = null;

   public Player getCurrentPlayer()
   {
      return this.currentPlayer;
   }

   public Game setCurrentPlayer(Player value)
   {
      if (this.currentPlayer != value)
      {
         Player oldValue = this.currentPlayer;
         if (this.currentPlayer != null)
         {
            this.currentPlayer = null;
            oldValue.setCurrentPlayerOf(null);
         }
         this.currentPlayer = value;
         if (value != null)
         {
            value.setCurrentPlayerOf(this);
         }
         firePropertyChange("currentPlayer", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_winner = "winner";

   private Player winner = null;

   public Player getWinner()
   {
      return this.winner;
   }

   public Game setWinner(Player value)
   {
      if (this.winner != value)
      {
         Player oldValue = this.winner;
         if (this.winner != null)
         {
            this.winner = null;
            oldValue.setWinnerOf(null);
         }
         this.winner = value;
         if (value != null)
         {
            value.setWinnerOf(this);
         }
         firePropertyChange("winner", oldValue, value);
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
      this.setFox(null);
      this.setGeese(null);
      this.setCurrentPlayer(null);
      this.setWinner(null);

   }


}