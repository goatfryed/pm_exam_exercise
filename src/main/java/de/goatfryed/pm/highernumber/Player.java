package de.goatfryed.pm.highernumber;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Player 
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public Player setName(String value)
   {
      if (value == null ? this.name != null : ! value.equals(this.name))
      {
         String oldValue = this.name;
         this.name = value;
         firePropertyChange("name", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_game = "game";

   private Game game = null;

   public Game getGame()
   {
      return this.game;
   }

   public Player setGame(Game value)
   {
      if (this.game != value)
      {
         Game oldValue = this.game;
         if (this.game != null)
         {
            this.game = null;
            oldValue.withoutPlayers(this);
         }
         this.game = value;
         if (value != null)
         {
            value.withPlayers(this);
         }
         firePropertyChange("game", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_gameWon = "gameWon";

   private Game gameWon = null;

   public Game getGameWon()
   {
      return this.gameWon;
   }

   public Player setGameWon(Game value)
   {
      if (this.gameWon != value)
      {
         Game oldValue = this.gameWon;
         if (this.gameWon != null)
         {
            this.gameWon = null;
            oldValue.setWinner(null);
         }
         this.gameWon = value;
         if (value != null)
         {
            value.setWinner(this);
         }
         firePropertyChange("gameWon", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_activeIn = "activeIn";

   private Game activeIn = null;

   public Game getActiveIn()
   {
      return this.activeIn;
   }

   public Player setActiveIn(Game value)
   {
      if (this.activeIn != value)
      {
         Game oldValue = this.activeIn;
         if (this.activeIn != null)
         {
            this.activeIn = null;
            oldValue.setCurrentPlayer(null);
         }
         this.activeIn = value;
         if (value != null)
         {
            value.setCurrentPlayer(this);
         }
         firePropertyChange("activeIn", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_picked = "picked";

   private Number picked = null;

   public Number getPicked()
   {
      return this.picked;
   }

   public Player setPicked(Number value)
   {
      if (this.picked != value)
      {
         Number oldValue = this.picked;
         if (this.picked != null)
         {
            this.picked = null;
            oldValue.setPickedBy(null);
         }
         this.picked = value;
         if (value != null)
         {
            value.setPickedBy(this);
         }
         firePropertyChange("picked", oldValue, value);
      }
      return this;
   }



   public static final java.util.ArrayList<Comment> EMPTY_comments = new java.util.ArrayList<Comment>()
   { @Override public boolean add(Comment value){ throw new UnsupportedOperationException("No direct add! Use xy.withComments(obj)"); }};


   public static final String PROPERTY_comments = "comments";

   private java.util.ArrayList<Comment> comments = null;

   public java.util.ArrayList<Comment> getComments()
   {
      if (this.comments == null)
      {
         return EMPTY_comments;
      }

      return this.comments;
   }

   public Player withComments(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withComments(i);
            }
         }
         else if (item instanceof Comment)
         {
            if (this.comments == null)
            {
               this.comments = new java.util.ArrayList<Comment>();
            }
            if ( ! this.comments.contains(item))
            {
               this.comments.add((Comment)item);
               ((Comment)item).setAuthor(this);
               firePropertyChange("comments", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Player withoutComments(Object... value)
   {
      if (this.comments == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutComments(i);
            }
         }
         else if (item instanceof Comment)
         {
            if (this.comments.contains(item))
            {
               this.comments.remove((Comment)item);
               ((Comment)item).setAuthor(null);
               firePropertyChange("comments", item, null);
            }
         }
      }
      return this;
   }


   public static final java.util.ArrayList<Comment> EMPTY_received = new java.util.ArrayList<Comment>()
   { @Override public boolean add(Comment value){ throw new UnsupportedOperationException("No direct add! Use xy.withReceived(obj)"); }};


   public static final String PROPERTY_received = "received";

   private java.util.ArrayList<Comment> received = null;

   public java.util.ArrayList<Comment> getReceived()
   {
      if (this.received == null)
      {
         return EMPTY_received;
      }

      return this.received;
   }

   public Player withReceived(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withReceived(i);
            }
         }
         else if (item instanceof Comment)
         {
            if (this.received == null)
            {
               this.received = new java.util.ArrayList<Comment>();
            }
            if ( ! this.received.contains(item))
            {
               this.received.add((Comment)item);
               ((Comment)item).withRecipients(this);
               firePropertyChange("received", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Player withoutReceived(Object... value)
   {
      if (this.received == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutReceived(i);
            }
         }
         else if (item instanceof Comment)
         {
            if (this.received.contains(item))
            {
               this.received.remove((Comment)item);
               ((Comment)item).withoutRecipients(this);
               firePropertyChange("received", item, null);
            }
         }
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

      result.append(" ").append(this.getName());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setGame(null);
      this.setGameWon(null);
      this.setActiveIn(null);
      this.setPicked(null);

      this.withoutComments(this.getComments().clone());


      this.withoutReceived(this.getReceived().clone());


   }


}