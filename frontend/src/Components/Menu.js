import React from 'react';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import SearchIcon from '@material-ui/icons/Search';
import CloudQueueIcon from '@material-ui/icons/CloudQueue';
import PersonOutlineIcon from '@material-ui/icons/PersonOutline';
import HistoryIcon from '@material-ui/icons/History';
import { Link } from 'react-router-dom';

export default function Menu(props) {
  var { createError } = props;

  return (
    <div>
      <List>
        <ListItem button component={Link} to={'/search'}>
          <ListItemIcon>
            <SearchIcon />
          </ListItemIcon>
          <ListItemText primary="Keresés" />
        </ListItem>
        <ListItem button component={Link} to={'/recommendations'}>
          <ListItemIcon>
            <CloudQueueIcon />
          </ListItemIcon>
          <ListItemText primary="Ajánlások" />
        </ListItem>
        <ListItem button component={Link} to={'#'} onClick={createError}>
          <ListItemIcon>
            <PersonOutlineIcon />
          </ListItemIcon>
          <ListItemText primary="Profil" />
        </ListItem>
        <ListItem button component={Link} to={'#'} onClick={createError}>
          <ListItemIcon>
            <HistoryIcon />
          </ListItemIcon>
          <ListItemText primary="Keresések" />
        </ListItem>
      </List>
    </div>
  );
}
