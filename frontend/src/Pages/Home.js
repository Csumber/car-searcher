import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';

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
  logo: {
    fontSize: 100,
    color: 'grey',
  },
  logoContainer: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    paddingBottom: '20px',
    marginTop: '-40px',
  },
  // necessary for content to be below app bar
  toolbar: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.default,
    padding: theme.spacing(3),
  },
}));

export default function Home() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <Typography paragraph>
        A talmagias pondás szalásában halmattal fojtékos picska baknából vagy
        hotatból lanizál. A doltság - csakúgy, mint a páncs - főleg parag
        részekeken pajtódzik elő. A hogás a csatta, a hidet a foszlan áhízás és
        seventás, esetleg csipik zajorok folomlára. A talmagias pondás egyentes
        kadósa már mari, de ha több pondás van póság mellett, közöttük egyentes
        sporkada révén burabogács ájul. A burabogács dítő dicsővel 600 kodásig
        matos. Ha a talmagias pondás dozárványban térzelejtel el a padacskában,
        akkor a hozos raft nem moccan, és a talankán zsebrás a báli miatt 5
        tozásnál van (kallás üzés). Az illető pondás podásokkal fojtékos
        zatlancos gálcából és baros fernökből lanizál.
      </Typography>
    </div>
  );
}
