import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import Divider from '@material-ui/core/Divider';
import Snackbar from '@material-ui/core/Snackbar';
import DriveEtaIcon from '@material-ui/icons/DriveEta';
import Menu from './Menu';
import Login from './Login';
import { useHistory } from 'react-router-dom';
import IconButton from '@material-ui/core/IconButton';
import Alert from '@material-ui/lab/Alert';
import { Link } from 'react-router-dom';

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
  },
  appBar: {
    width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: drawerWidth,
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
  },
  drawerPaper: {
    width: drawerWidth,
  },
  logoContainer: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
  },
  logoButton: {
    minHeight: '140px',
  },
  logo: {
    fontSize: '150px',
    color: 'grey',
  },
  // necessary for content to be below app bar
  toolbar: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.default,
    padding: theme.spacing(3),
  },
}));

export default function DrawerMenu() {
  const classes = useStyles();

  const [open, setOpen] = React.useState(false);

  const createError = () => {
    setOpen(true);
  };
  const handleClose = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }
    setOpen(false);
  };

  return (
    <Drawer
      className={classes.drawer}
      variant="permanent"
      classes={{
        paper: classes.drawerPaper,
      }}
      anchor="left"
    >
      <Snackbar open={open} autoHideDuration={3000} onClose={handleClose}>
        <Alert onClose={handleClose} severity="error">
          Ez a funkció jelenleg nem elérhető!
        </Alert>
      </Snackbar>
      <IconButton
        aria-label="home"
        className={classes.logoButton}
        component={Link}
        to={'#'}
      >
        <DriveEtaIcon className={classes.logo} />
      </IconButton>
      <Divider />
      <Menu createError={createError} />
      <Divider />
      <Login />
    </Drawer>
  );
}
