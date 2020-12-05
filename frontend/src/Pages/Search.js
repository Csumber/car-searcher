import React from 'react';
import clsx from 'clsx';
import PropTypes from 'prop-types';
import {
  Box,
  Button,
  Card,
  CardHeader,
  Divider,
  makeStyles,
} from '@material-ui/core';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import TextField from '@material-ui/core/TextField';
import Typography from '@material-ui/core/Typography';
import InputAdornment from '@material-ui/core/InputAdornment';
import Input from '@material-ui/core/Input';
import MenuItem from '@material-ui/core/MenuItem';
import ListItemText from '@material-ui/core/ListItemText';
import Checkbox from '@material-ui/core/Checkbox';

const useStyles = makeStyles((theme) => ({
  root: {
    width: '100%',
    float: 'left',
  },
  actions: {
    justifyContent: 'flex-end',
  },
  formControl: {
    margin: theme.spacing(1),
    minWidth: 150,
  },
  formControl2: {
    margin: theme.spacing(1),
    minWidth: 300,
  },
}));

const LatestOrders = ({ className, ...rest }) => {
  const ITEM_HEIGHT = 48;
  const ITEM_PADDING_TOP = 8;
  const MenuProps = {
    PaperProps: {
      style: {
        maxHeight: ITEM_HEIGHT * 4.5 + ITEM_PADDING_TOP,
        width: 250,
      },
    },
  };

  const engines = ['Motor 1', 'Motor 2', 'Motor 3', 'Motor 4'];
  const enginesSelected = [];

  const classes = useStyles();
  const [state, setState] = React.useState({
    age: '',
    name: 'hai',
  });

  const handleChange = (event) => {
    const name = event.target.name;
    setState({
      ...state,
      [name]: event.target.value,
    });
  };

  return (
    <Card className={clsx(classes.root, className)} {...rest}>
      <CardHeader title="Keresés" />
      <Divider />

      <Box width="100%" display="flex" justifyContent="space-evenly" p={2}>
        <FormControl variant="outlined" className={classes.formControl}>
          <InputLabel htmlFor="outlined-age-native-simple">Gyártó</InputLabel>
          <Select
            native
            value={state.age}
            onChange={handleChange}
            label="Gyártó"
            inputProps={{
              name: 'manufacturer',
              id: 'manufacturer-selector',
            }}
          >
            <option aria-label="None" value="" />
            <option value="audi">Audi</option>
            <option value="bmw">BMW</option>
            <option value="lada">Lada</option>
          </Select>
        </FormControl>
        <FormControl
          variant="outlined"
          className={classes.formControl}
          disabled
        >
          <InputLabel htmlFor="outlined-age-native-simple">Modell</InputLabel>
          <Select native onChange={handleChange} label="Modell">
            <option aria-label="None" value="" disabled />
            <option value="series 5">Series 5</option>
            <option value="a4">A4</option>
          </Select>
        </FormControl>
        <FormControl variant="outlined" className={classes.formControl}>
          <InputLabel htmlFor="outlined-age-native-simple">
            Kivitel(ek)
          </InputLabel>
          <Select
            native
            value={state.age}
            onChange={handleChange}
            label="Kivitel(ek)"
            inputProps={{
              name: 'manufacturer',
              id: 'manufacturer-selector',
            }}
          >
            <option aria-label="None" value="" />
            <option value="sedan">Szedán</option>
            <option value="wagon">Kombi</option>
            <option value="Coupé">Kupé</option>
          </Select>
        </FormControl>
        <FormControl variant="outlined" className={classes.formControl}>
          <InputLabel htmlFor="outlined-age-native-simple">
            Ajtók Száma
          </InputLabel>
          <Select
            native
            value={state.age}
            onChange={handleChange}
            label="Ajtók Száma"
            inputProps={{
              name: 'manufacturer',
              id: 'manufacturer-selector',
            }}
          >
            <option aria-label="None" value="" />
            <option value={1}>1</option>
            <option value={2}>2</option>
            <option value={3}>3</option>
            <option value={4}>4</option>
            <option value={5}>5</option>
          </Select>
        </FormControl>
      </Box>

      <Box width="100%" display="flex" justifyContent="space-evenly" p={2}>
        <FormControl variant="outlined" className={classes.formControl}>
          <TextField
            id="standard-number"
            label="Ár minimum"
            type="number"
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">Ft</InputAdornment>
              ),
            }}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </FormControl>
        <Typography variant="h2" color="textSecondary">
          -
        </Typography>
        <FormControl variant="outlined" className={classes.formControl}>
          <TextField
            id="standard-number"
            label="Ár maximum"
            type="number"
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">Ft</InputAdornment>
              ),
            }}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </FormControl>
        <FormControl variant="outlined" className={classes.formControl}>
          <TextField
            id="standard-number"
            label="Garancia minimum"
            type="number"
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">Év</InputAdornment>
              ),
            }}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </FormControl>
        <Typography variant="h2" color="textSecondary">
          -
        </Typography>
        <FormControl variant="outlined" className={classes.formControl}>
          <TextField
            id="standard-number"
            label="Garancia maximum"
            type="number"
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">Év</InputAdornment>
              ),
            }}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </FormControl>
      </Box>

      <Box width="100%" display="flex" justifyContent="space-evenly" p={2}>
        <FormControl variant="outlined" className={classes.formControl}>
          <TextField
            id="standard-number"
            label="Szélesség minimum"
            type="number"
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">cm</InputAdornment>
              ),
            }}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </FormControl>
        <Typography variant="h2" color="textSecondary">
          -
        </Typography>
        <FormControl variant="outlined" className={classes.formControl}>
          <TextField
            id="standard-number"
            label="Szélesség maximum"
            type="number"
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">cm</InputAdornment>
              ),
            }}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </FormControl>
        <FormControl variant="outlined" className={classes.formControl}>
          <TextField
            id="standard-number"
            label="Hossz minimum"
            type="number"
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">cm</InputAdornment>
              ),
            }}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </FormControl>
        <Typography variant="h2" color="textSecondary">
          -
        </Typography>
        <FormControl variant="outlined" className={classes.formControl}>
          <TextField
            id="standard-number"
            label="Hossz maximum"
            type="number"
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">cm</InputAdornment>
              ),
            }}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </FormControl>
      </Box>

      <Box width="100%" display="flex" justifyContent="space-evenly" p={2}>
        <FormControl variant="outlined" className={classes.formControl}>
          <TextField
            id="standard-number"
            label="Tömeg minimum"
            type="number"
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">kg</InputAdornment>
              ),
            }}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </FormControl>
        <Typography variant="h2" color="textSecondary">
          -
        </Typography>
        <FormControl variant="outlined" className={classes.formControl}>
          <TextField
            id="standard-number"
            label="Tömeg maximum"
            type="number"
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">kg</InputAdornment>
              ),
            }}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </FormControl>
        <div className={classes.formControl}></div>
        <div className={classes.formControl}></div>
        <div className={classes.formControl}></div>
      </Box>

      <Box width="100%" display="flex" justifyContent="space-evenly" p={2}>
        <FormControl className={classes.formControl2}>
          <InputLabel id="demo-mutiple-checkbox-label">Motor(ok)</InputLabel>
          <Select
            labelId="demo-mutiple-checkbox-label"
            id="demo-mutiple-checkbox"
            multiple
            value={enginesSelected}
            onChange={handleChange}
            input={<Input />}
            renderValue={(selected) => selected.join(', ')}
            MenuProps={MenuProps}
          >
            {engines.map((name) => (
              <MenuItem key={name} value={name}>
                <Checkbox checked={name.indexOf(name) > -1} />
                <ListItemText primary={name} />
              </MenuItem>
            ))}
          </Select>
        </FormControl>
        <FormControl className={classes.formControl2}>
          <InputLabel id="demo-mutiple-checkbox-label">Extra(k)</InputLabel>
          <Select
            labelId="demo-mutiple-checkbox-label"
            id="demo-mutiple-checkbox"
            multiple
            value={enginesSelected}
            onChange={handleChange}
            input={<Input />}
            renderValue={(selected) => selected.join(', ')}
            MenuProps={MenuProps}
          >
            {engines.map((name) => (
              <MenuItem key={name} value={name}>
                <Checkbox checked={name.indexOf(name) > -1} />
                <ListItemText primary={name} />
              </MenuItem>
            ))}
          </Select>
        </FormControl>

        <div className={classes.formControl}></div>
        <div className={classes.formControl}></div>
      </Box>

      <Box display="flex" justifyContent="flex-end" p={2}>
        <Button
          color="primary"
          variant="contained"
          size="large"
          href="/searchresults"
        >
          Keresés
        </Button>
      </Box>
    </Card>
  );
};

LatestOrders.propTypes = {
  className: PropTypes.string,
};

export default LatestOrders;
