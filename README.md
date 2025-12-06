# Project: Chore Splitter

## Contributors
Darian Liang, Daniel Wong

## Dependencies
- Java 8 or higher
- No external libraries required (using standard Java libraries only)

## Build Instructions

### Compile the project:
```bash
cd src
javac ChoreSplitterApp.java
```

### Run the application:
```bash
java ChoreSplitterApp
```
## Data Storage
The application stores data in a `data/` directory in the root of the project:
- `data/users.txt` - User account information (email, password, name)
- `data/households.txt` - Household information (id, name, description, join code, owner email, member emails)
- `data/chores.txt` - Chore information (id, household id, description, priority, type, assigned to, completion status, completion date)
