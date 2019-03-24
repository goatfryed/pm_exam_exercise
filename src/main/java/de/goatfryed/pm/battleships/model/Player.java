package de.goatfryed.pm.battleships.model;

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



   public static final String PROPERTY_active = "active";

   private Game active = null;

   public Game getActive()
   {
      return this.active;
   }

   public Player setActive(Game value)
   {
      if (this.active != value)
      {
         Game oldValue = this.active;
         if (this.active != null)
         {
            this.active = null;
            oldValue.setCurrentPlayer(null);
         }
         this.active = value;
         if (value != null)
         {
            value.setCurrentPlayer(this);
         }
         firePropertyChange("active", oldValue, value);
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



   public static final java.util.ArrayList<Boat> EMPTY_boats = new java.util.ArrayList<Boat>()
   { @Override public boolean add(Boat value){ throw new UnsupportedOperationException("No direct add! Use xy.withBoats(obj)"); }};


   public static final String PROPERTY_boats = "boats";

   private java.util.ArrayList<Boat> boats = null;

   public java.util.ArrayList<Boat> getBoats()
   {
      if (this.boats == null)
      {
         return EMPTY_boats;
      }

      return this.boats;
   }

   public Player withBoats(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withBoats(i);
            }
         }
         else if (item instanceof Boat)
         {
            if (this.boats == null)
            {
               this.boats = new java.util.ArrayList<Boat>();
            }
            if ( ! this.boats.contains(item))
            {
               this.boats.add((Boat)item);
               ((Boat)item).setPlayer(this);
               firePropertyChange("boats", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Player withoutBoats(Object... value)
   {
      if (this.boats == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutBoats(i);
            }
         }
         else if (item instanceof Boat)
         {
            if (this.boats.contains(item))
            {
               this.boats.remove((Boat)item);
               ((Boat)item).setPlayer(null);
               firePropertyChange("boats", item, null);
            }
         }
      }
      return this;
   }


   public static final java.util.ArrayList<Shot> EMPTY_shots = new java.util.ArrayList<Shot>()
   { @Override public boolean add(Shot value){ throw new UnsupportedOperationException("No direct add! Use xy.withShots(obj)"); }};


   public static final String PROPERTY_shots = "shots";

   private java.util.ArrayList<Shot> shots = null;

   public java.util.ArrayList<Shot> getShots()
   {
      if (this.shots == null)
      {
         return EMPTY_shots;
      }

      return this.shots;
   }

   public Player withShots(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withShots(i);
            }
         }
         else if (item instanceof Shot)
         {
            if (this.shots == null)
            {
               this.shots = new java.util.ArrayList<Shot>();
            }
            if ( ! this.shots.contains(item))
            {
               this.shots.add((Shot)item);
               ((Shot)item).setPlayer(this);
               firePropertyChange("shots", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Player withoutShots(Object... value)
   {
      if (this.shots == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutShots(i);
            }
         }
         else if (item instanceof Shot)
         {
            if (this.shots.contains(item))
            {
               this.shots.remove((Shot)item);
               ((Shot)item).setPlayer(null);
               firePropertyChange("shots", item, null);
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
      this.setActive(null);
      this.setGameWon(null);

      this.withoutBoats(this.getBoats().clone());


      this.withoutShots(this.getShots().clone());


      this.withoutSections(this.getSections().clone());


   }


   public static final java.util.ArrayList<Section> EMPTY_sections = new java.util.ArrayList<Section>()
   { @Override public boolean add(Section value){ throw new UnsupportedOperationException("No direct add! Use xy.withSections(obj)"); }};


   public static final String PROPERTY_sections = "sections";

   private java.util.ArrayList<Section> sections = null;

   public java.util.ArrayList<Section> getSections()
   {
      if (this.sections == null)
      {
         return EMPTY_sections;
      }

      return this.sections;
   }

   public Player withSections(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withSections(i);
            }
         }
         else if (item instanceof Section)
         {
            if (this.sections == null)
            {
               this.sections = new java.util.ArrayList<Section>();
            }
            if ( ! this.sections.contains(item))
            {
               this.sections.add((Section)item);
               ((Section)item).setPlayer(this);
               firePropertyChange("sections", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Player withoutSections(Object... value)
   {
      if (this.sections == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutSections(i);
            }
         }
         else if (item instanceof Section)
         {
            if (this.sections.contains(item))
            {
               this.sections.remove((Section)item);
               ((Section)item).setPlayer(null);
               firePropertyChange("sections", item, null);
            }
         }
      }
      return this;
   }


}