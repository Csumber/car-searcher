import React from 'react';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import CloseIcon from '@material-ui/icons/Close';

export default function Login() {
  const [login, setLogin] = React.useState(false);

  const handleLogin = (event, reason) => {
    setLogin(true);
  };

  const handleLogout = (event, reason) => {
    setLogin(false);
  };

  if (!login) {
    return (
      <List>
        <ListItem button onClick={handleLogin}>
          <ListItemIcon>
            <ExitToAppIcon />
          </ListItemIcon>
          <ListItemText primary="Bejelentkezés" />
        </ListItem>
      </List>
    );
  } else {
    return (
      <List>
        <ListItem button onClick={handleLogout}>
          <ListItemIcon>
            <CloseIcon />
          </ListItemIcon>
          <ListItemText primary="Kijelentkezés" />
        </ListItem>
      </List>
    );
  }
}
