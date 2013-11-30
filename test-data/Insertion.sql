
INSERT INTO users VALUES ( 1, 'Fluffy', 'Buttons', 'fbutton', 'f', 'abc123',1 );
INSERT INTO users VALUES ( 2, 'Edward', 'Jones', 'ejones', 'm', 'hello',2 );
INSERT INTO dietition VALUES ( 2, 1 );
INSERT INTO usertype VALUES ( 1,'Vegetarian' );
INSERT INTO usertype VALUES ( 2,'Vegan' );

INSERT INTO emails VALUES ( 'fluffybuttons@gmail.com',1 );
INSERT INTO emails VALUES ( 'fateburnxvi@hotmail.com',2 );
INSERT INTO emails VALUES ( 'oldguy101@aol.com',1 );
INSERT INTO emails VALUES ( 'hogie@sammich.net',2 );

INSERT INTO attributes VALUES ( 1, 'Low Sodium' );
INSERT INTO attributes VALUES ( 2, 'Low Fat' );
INSERT INTO attributes VALUES ( 3, 'Vegetarian' );
INSERT INTO attributes VALUES ( 4, 'Vegan' );
INSERT INTO attributes VALUES ( 5, 'Gluten Free' );

INSERT INTO dayplans VALUES ( '2013-11-25', 1 );
INSERT INTO dayplans VALUES ( '2013-11-26', 2 );
INSERT INTO dayplans VALUES ( '2013-11-27', 1 );
INSERT INTO dayplans VALUES ( '2013-11-28', 2 );

INSERT INTO ingredients VALUES ( 1,'Chicken', 8, 250 );
INSERT INTO ingredients VALUES ( 2,'Waffles', 1, 100 );
INSERT INTO ingredients VALUES ( 3,'Tofu', 1, 50 );
INSERT INTO ingredients VALUES ( 4,'Vegetable Broth', 1, 90 );
INSERT INTO ingredients VALUES ( 5,'Bacon', 6, 90 );
INSERT INTO ingredients VALUES ( 6,'Eggs', 1, 90 );
INSERT INTO ingredients VALUES ( 7,'Sausage', 5, 90 );
INSERT INTO ingredients VALUES ( 8,'Bread', 0, 90 );
INSERT INTO ingredients VALUES ( 9,'Butter', 3, 90 );
INSERT INTO ingredients VALUES ( 10,'Syrup', 1, 90 );
INSERT INTO ingredients VALUES ( 11,'Honey', 1, 90 );
INSERT INTO ingredients VALUES ( 12,'General Sauce', 5, 90 );

INSERT INTO courses VALUES ( 1,'Eggs Over Easy', 1 );
INSERT INTO courses VALUES ( 2,'Scrambled Eggs', 1 );
INSERT INTO courses VALUES ( 3,'Toast', 1 );
INSERT INTO courses VALUES ( 4,'Skillet Fried Sausage', 1 );
INSERT INTO courses VALUES ( 5,'Waffles', 1 );
INSERT INTO courses VALUES ( 6,'Honey Roasted Chicken', 1 );
INSERT INTO courses VALUES ( 7,'General Tofu', 1 );

INSERT INTO meals VALUES ( 1,'Japanese Sukiyaki Dinner' );
INSERT INTO meals VALUES ( 2,'Chicken and Waffles Breakfast' );
INSERT INTO meals VALUES ( 3,'All American Breakfast' );

INSERT INTO ratings VALUES ( 1,1,1 );
INSERT INTO ratings VALUES ( 2,1,4 );
INSERT INTO ratings VALUES ( 3,2,3.5 );
INSERT INTO ratings VALUES ( 4,1,5 );

INSERT INTO mealscourses VALUES ( 1, 7 );
INSERT INTO mealscourses VALUES ( 2, 6 );
INSERT INTO mealscourses VALUES ( 2, 5 );
INSERT INTO mealscourses VALUES ( 3, 1 );
INSERT INTO mealscourses VALUES ( 3, 2 );
INSERT INTO mealscourses VALUES ( 3, 3 );
INSERT INTO mealscourses VALUES ( 3, 4 );

INSERT INTO ingredientscourses VALUES ( 6, 1 );
INSERT INTO ingredientscourses VALUES ( 6, 2 );
INSERT INTO ingredientscourses VALUES ( 8, 3 );
INSERT INTO ingredientscourses VALUES ( 9, 3 );
INSERT INTO ingredientscourses VALUES ( 7, 4 );
INSERT INTO ingredientscourses VALUES ( 9, 5 );
INSERT INTO ingredientscourses VALUES ( 10, 5 );
INSERT INTO ingredientscourses VALUES ( 2, 5 );
INSERT INTO ingredientscourses VALUES ( 1, 6 );
INSERT INTO ingredientscourses VALUES ( 11, 6 );
INSERT INTO ingredientscourses VALUES ( 3, 7 );
INSERT INTO ingredientscourses VALUES ( 12, 7 );

INSERT INTO UserSelectedMeals VALUES ( 1, 1, '2013-11-25' );
INSERT INTO UserSelectedMeals VALUES ( 1, 1, '2013-11-26' );
INSERT INTO UserSelectedMeals VALUES ( 1, 1, '2013-11-27' );
INSERT INTO UserSelectedMeals VALUES ( 1, 1, '2013-11-28' );
INSERT INTO UserSelectedMeals VALUES ( 2, 1, '2013-11-25' );
INSERT INTO UserSelectedMeals VALUES ( 2, 2, '2013-11-25' );
INSERT INTO UserSelectedMeals VALUES ( 2, 3, '2013-11-25' );
